package com.tnt.another.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tnt.another.consumer.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserConsumerService {

	// TODO: read topic name from config file
	@KafkaListener(topics = "${tnt.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "userKafkaListenerContainerFactory")
	public void consumeMessage(UserDto dto) {
		log.info("User iformation consumed in ANOTHER consumer service: {}", dto);
	}

}
