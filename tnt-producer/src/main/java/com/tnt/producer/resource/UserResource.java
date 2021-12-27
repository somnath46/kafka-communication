package com.tnt.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.producer.dto.UserDto;
import com.tnt.producer.service.UserProducerService;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

	@Autowired
	private UserProducerService userProducerService;

	@PostMapping
	public void createUser(@RequestBody UserDto dto) {
		userProducerService.produceUserInfo(dto);
	}
}
