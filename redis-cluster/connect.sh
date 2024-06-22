#!/bin/bash


# redis-cli -p 7000 -a bitnami --tls --cert ./tls/client.crt --key ./tls/client.key --cacert ./tls/ca.crt "$@"
 redis-cli -p 7000 -a bitnami --tls --cert ./tls/client1.crt --key ./tls/client1.key --cacert ./tls/ca.crt "$@"
