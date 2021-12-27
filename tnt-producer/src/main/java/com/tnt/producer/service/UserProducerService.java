package com.tnt.producer.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tnt.producer.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserProducerService {

	@Value("${tnt.kafka.topic}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, UserDto> kafkaTemplate;

	public void produceUserInfo(UserDto dto) {
		dto.setId(UUID.randomUUID());
		log.info("Producing data into kafka for user: {}", dto);
		kafkaTemplate.send(topic, dto);
	}

}
