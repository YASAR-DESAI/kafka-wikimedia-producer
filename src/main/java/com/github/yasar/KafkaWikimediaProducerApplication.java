package com.github.yasar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaWikimediaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(KafkaWikimediaProducerApplication.class, args);
	}

	@Autowired
	private WikiMediaProducer wikiMediaProducer;

	public void run(String... args) throws Exception {
		wikiMediaProducer.sendMessage();
	}
}
