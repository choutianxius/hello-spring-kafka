package com.choutianxius.hello_spring_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringKafkaApplication {

	public static void main(String[] args) {
		System.out.println("Hi, Spring Kafka!");
		SpringApplication.run(HelloSpringKafkaApplication.class, args);
	}

}
