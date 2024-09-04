#!/usr/bin/bash

declare -a topics=("gps")

for topic in "${topics[@]}"
do
  /opt/bitnami/kafka/bin/kafka-topics.sh --create --if-not-exists --topic "$topic" --bootstrap-server kafka:9092
done
