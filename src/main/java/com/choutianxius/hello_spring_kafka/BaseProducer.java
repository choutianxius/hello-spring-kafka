package com.choutianxius.hello_spring_kafka;

public interface BaseProducer {
  abstract void produce(String key, String data);
}
