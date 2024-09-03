# A Project for Learning Spring for Apache Kafka

This project implements a system using [Spring for Apache Kafka](https://spring.io/projects/spring-kafka), achieving the following features:

- (Topic 1) Receive raw messages, which represent some activity record, from HTTP POST requests and put them into the Kafka queue;
- (Topic 2) Upon receiving a valid message from topic 1, asynchronously perform some data fetching from a fake data store. The fetched data are placed in a Redis cache, and when all message for one record are received, persist the record in a database.