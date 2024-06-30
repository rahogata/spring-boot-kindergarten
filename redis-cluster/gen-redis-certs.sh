
#!/bin/bash

# COPIED/MODIFIED from the redis server gen-certs util
# https://github.com/redis/redis/blob/cc0091f0f9fe321948c544911b3ea71837cf86e3/utils/gen-test-certs.sh

# Generate some test certificates which are used by the regression test suite:
#
#   tls/ca.{crt,key}          Self signed CA certificate.
#   tls/redis.{crt,key}       A certificate with no key usage/policy restrictions.
#   tls/client.{crt,key}      A certificate restricted for SSL client usage.
#   tls/server.{crt,key}      A certificate restricted for SSL server usage.
#   tls/redis.dh              DH Params file.

generate_cert() {
    local name=$1
    local cn="$2"
    local opts="$3"

    local keyfile=tls/${name}.key
    local certfile=tls/${name}.crt

    [ -f $keyfile ] || openssl genrsa -out $keyfile 2048
    openssl req \
        -new -sha256 \
        -subj "/O=Redis Test/CN=$cn" \
        -key $keyfile | \
        openssl x509 \
            -req -sha256 \
            -CA tls/ca.crt \
            -CAkey tls/ca.key \
            -CAserial tls/ca.txt \
            -CAcreateserial \
            -days 365 \
            $opts \
            -out $certfile
}

mkdir -p tls
[ -f tls/ca.key ] || openssl genrsa -out tls/ca.key 4096
openssl req \
    -x509 -new -nodes -sha256 \
    -key tls/ca.key \
    -days 3650 \
    -subj '/O=Redis Test/CN=Certificate Authority' \
    -out tls/ca.crt

cat > tls/openssl.cnf <<_END_
[alt_names]
DNS.1 = redis-node-0
DNS.2 = redis-node-1
DNS.3 = redis-node-2
DNS.4 = redis-node-3
DNS.5 = redis-node-4
DNS.6 = redis-node-5
IP.1 = 172.21.0.11
IP.2 = 172.21.0.12
IP.3 = 172.21.0.13
IP.4 = 172.21.0.14
IP.5 = 172.21.0.15
IP.6 = 172.21.0.16
[ server_cert ]
keyUsage = digitalSignature, keyEncipherment
nsCertType = server, client
subjectAltName = @alt_names
[ client_cert ]
keyUsage = digitalSignature, keyEncipherment
nsCertType = client
_END_

generate_cert server "*" "-extfile tls/openssl.cnf -extensions server_cert"
generate_cert client "*" "-extfile tls/openssl.cnf -extensions client_cert"
#generate_cert redis "*" '-extfile tls/openssl.cnf -extensions redis_cert'

[ -f tls/redis.dh ] || openssl dhparam -out tls/redis.dh 2048
[ -f tls/redis-client.p12 ] || openssl pkcs12 -export -out tls/redis-client.p12 -inkey tls/client.key -in tls/client.crt -passout pass:ramana
[ -f tls/ca.p12 ] || cat tls/server.crt tls/ca.crt > tls/ca-chain.crt && keytool -importcert -keystore tls/ca.p12 -storetype PKCS12 -alias redisca -file tls/ca-chain.crt -storepass ramana -noprompt
#keytool -importcert -keystore tls/ca.p12 -storetype PKCS12 -alias redisserver -file tls/server.crt -storepass ramana -noprompt
#keytool -importcert -keystore tls/ca.p12 -storetype PKCS12 -alias rediscluster -file tls/redis.crt -storepass ramana -noprompt
rm -f tls/ca-chain.crt
