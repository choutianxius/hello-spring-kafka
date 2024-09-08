package com.choutianxius.hello_spring_kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastFetcher implements BaseConsumer<String, GpsMessage> {
  private static final String TOPIC = "gps";
  private static final String GROUP_ID = "weather_forecast";
  private static final Logger logger = LoggerFactory.getLogger(WeatherForecastFetcher.class);
  private static final String VALKEY_PREFIX = "weather:";
  private final RedisTemplate<String, String> redisTemplate;

  @Autowired
  public WeatherForecastFetcher(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
  public void consume(@Header(KafkaHeaders.RECEIVED_KEY) String key, GpsMessage message) {
    // TODO: Fetch weather forecast from third-party REST API endpoint
    logger.info("Weather forecast consumer received {}: {}", key, message);

    String fakeWeatherForecast = fakeWeatherForecastApi(message.latitude(), message.longitude());
    redisTemplate.opsForValue().set(VALKEY_PREFIX + key, fakeWeatherForecast);
    logger.info(
        "Data inserted to Valkey: {}: {}",
        VALKEY_PREFIX + key,
        redisTemplate.opsForValue().get(VALKEY_PREFIX + key));
  }

  private String fakeWeatherForecastApi(double latitude, double longitude) {
    return "Sunny";
  }
}
