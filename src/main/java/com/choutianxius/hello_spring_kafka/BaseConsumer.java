package com.choutianxius.hello_spring_kafka;

public interface BaseConsumer<K, V> {
  abstract void consume(K key, V data);
}
