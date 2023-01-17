package com.example.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.dto.KafkaMessage;
import com.example.producer.service.KafkaProducerService;

@RestController
@RequestMapping("api/kafka")
public class ProduceMessageController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@PostMapping("/produce")
	public void sendMessage(@RequestBody List<KafkaMessage> kafkaMessageList) {
		kafkaProducerService.sendMessage(kafkaMessageList);
	}
}
