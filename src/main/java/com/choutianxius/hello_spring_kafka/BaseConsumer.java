package com.choutianxius.hello_spring_kafka;

public interface BaseConsumer {
  abstract void consume(String key, String data);
}
