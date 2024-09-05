# A Project for Learning Spring for Apache Kafka

Imagine a health-keeping system to provide activity suggestions for users, supporting the following features:

- Monitoring users' GPS locations, receiving them through HTTP post requests;
- Upon receiving GPS messages, fetch the weather condition forecast of the user's current location, from a third-party REST API;
- Upon receiving GPS messages, fetch the user's physical monitoring data, which is obtained by a third-party wearable device and dumped into some AWS S3 bucket.

This project implements such a system using [Spring for Apache Kafka](https://spring.io/projects/spring-kafka) and [Redis]().

## TODO

- [ ] Define models for messages and implement serialization
- [ ] Implement interaction with Redis
- [ ] Implement interaction with DynamoDB