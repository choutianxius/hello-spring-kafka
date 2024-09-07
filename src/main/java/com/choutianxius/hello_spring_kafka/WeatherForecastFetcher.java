package com.choutianxius.hello_spring_kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastFetcher implements BaseConsumer<String, GpsMessage> {
  private static final String TOPIC = "gps";
  private static final String GROUP_ID = "weather_forecast";
  private static final Logger logger = LoggerFactory.getLogger(WeatherForecastFetcher.class);

  @Override
  @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
  public void consume(@Header(KafkaHeaders.RECEIVED_KEY) String key, GpsMessage message) {
    // TODO: Fetch weather forecast from third-party REST API endpoint
    logger.info("Weather forecast consumer received {}: {}", key, message);
  }
}
