package com.choutianxius.hello_spring_kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicHandler {
  private static final String TOPIC = "mytopic";
  private final KafkaTemplate<String, String> template;

  private final Logger logger = LoggerFactory.getLogger(TopicHandler.class);

  @Autowired
  public TopicHandler(KafkaTemplate<String, String> template) {
    this.template = template;
  }

  private static String processMessage(String rawMessage) {
    return rawMessage.toUpperCase();
  }

  @PostMapping("/")
  public void produce(@RequestBody String message) {
    template.send(TOPIC, message);
  }

  @KafkaListener(topics = TOPIC, groupId = "default")
  public void consume(String in) {
    logger.info(processMessage(in));
  }
}
