package com.choutianxius.hello_spring_kafka;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GpsProducer implements BaseProducer {
  private static final String TOPIC = "gps";
  private static final Logger logger = LoggerFactory.getLogger(GpsProducer.class);
  private final KafkaTemplate<String, String> template;

  @Autowired
  public GpsProducer(KafkaTemplate<String, String> template) {
    this.template = template;
  }

  @PostMapping("/")
  public void receiveHttpPostData(@RequestBody String body) {
    logger.info("Received data: {} at {}", body, new Date());
    produce("placeholder", body);
  }

  @Override
  public void produce(String key, String message) {
    template.send(TOPIC, key, message);
  }
}
