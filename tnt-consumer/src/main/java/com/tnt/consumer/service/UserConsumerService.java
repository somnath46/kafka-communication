package com.tnt.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tnt.consumer.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserConsumerService {

	// TODO: read topic name from config file
	@KafkaListener(topics = "dummy-topic", groupId = "dummy-topic-group")
	public void consumeMessage(UserDto dto) {
		log.info("User iformation consumed in consumer service: {}", dto);
	}

}
