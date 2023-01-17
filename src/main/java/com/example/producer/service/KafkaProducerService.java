package com.example.producer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.producer.dto.KafkaMessage;

@Service
public class KafkaProducerService {

	@Value("${spring.kafka.topic.name}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void sendMessage(@RequestBody List<KafkaMessage> kafkaMessageList) {
		kafkaMessageList.forEach(kafkaMessage -> kafkaTemplate.send(topic, UUID.randomUUID().toString(), kafkaMessage));
	}
}
