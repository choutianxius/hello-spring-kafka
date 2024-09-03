package com.choutianxius.hello_spring_kafka;

public abstract class BaseTopicHandler {
  /** Kafka topic name */
  public static String TOPIC;

  /**
   * Receive an outside message, process it if necessary, and put it into to the Kafka queue
   *
   * @param message Message to be processed and put into the Kafka queue
   */
  public abstract void produce(String message);

  /**
   * Process a message in the Kafka queue
   *
   * @param message Message from the Kafka queue
   */
  public abstract void consume(String message);
}
