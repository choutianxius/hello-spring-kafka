package com.choutianxius.hello_spring_kafka;

public interface BaseProducer<K, V> {
  abstract void produce(K key, V data);
}
