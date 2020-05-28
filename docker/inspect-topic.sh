#!/usr/bin/env bash

TOPIC=$1

docker-compose exec kafka kafka-console-consumer \
    --bootstrap-server kafka:29092 \
    --topic $TOPIC \
    --from-beginning
