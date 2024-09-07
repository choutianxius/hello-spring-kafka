package com.choutianxius.hello_spring_kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class PhysicalStatusFetcher implements BaseConsumer<String, GpsMessage> {
  private static final String TOPIC = "gps";
  private static final String GROUP_ID = "physical_status";
  private static final Logger logger = LoggerFactory.getLogger(PhysicalStatusFetcher.class);

  @Override
  @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
  public void consume(@Header(KafkaHeaders.RECEIVED_KEY) String key, GpsMessage message) {
    // TODO: Fetch physical status data from third-party S3 buckets
    logger.info("Physical status consumer received {}: {}", key, message);
  }
}
