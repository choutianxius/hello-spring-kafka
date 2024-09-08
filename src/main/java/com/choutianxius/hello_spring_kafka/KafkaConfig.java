package com.choutianxius.hello_spring_kafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfig {
  private final KafkaProperties properties;

  public KafkaConfig(KafkaProperties injectedProperties) {
    // Injected from application.properties by Spring Boot
    this.properties = injectedProperties;
  }

  @Bean
  public ProducerFactory<String, GpsMessage> producerFactory() {
    return new DefaultKafkaProducerFactory<>(
        properties.buildProducerProperties(null), new StringSerializer(), new JsonSerializer<>());
  }

  @Bean
  public KafkaTemplate<String, GpsMessage> kafkaTemplate(
      ProducerFactory<String, GpsMessage> producerFactory) {
    return new KafkaTemplate<>(producerFactory);
  }

  @Bean
  public ConsumerFactory<String, GpsMessage> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(
        properties.buildConsumerProperties(null),
        new StringDeserializer(),
        new JsonDeserializer<>(GpsMessage.class));
  }

  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, GpsMessage>>
      kafkaListenerContainerFactory(ConsumerFactory<String, GpsMessage> consumerFactory) {
    ConcurrentKafkaListenerContainerFactory<String, GpsMessage> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory);
    return factory;
  }
}
