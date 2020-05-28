#!/usr/bin/env bash

docker-compose exec kafka kafka-topics \
      --bootstrap-server kafka:29092 \
      --list
