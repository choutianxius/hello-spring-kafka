#!/usr/bin/bash

declare -a topics=("topic1" "topic2")

for topic in "${topics[@]}"
do
  /opt/bitnami/kafka/bin/kafka-topics.sh --create --if-not-exists --topic "$topic" --bootstrap-server kafka:9092
done
