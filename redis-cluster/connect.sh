#!/bin/bash

 redis-cli -p 7000 -a bitnami --tls --cert ./tls/redis.crt --key ./tls/redis.key --cacert ./tls/ca.crt "$@"
