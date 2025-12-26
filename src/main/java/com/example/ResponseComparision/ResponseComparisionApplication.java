package com.example.ResponseComparision;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResponseComparisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseComparisionApplication.class, args);
	}

	// This method FORCES Spring to use your URI, overriding any rogue configuration
	@Bean
	public MongoClient mongoClient(@Value("${spring.data.mongodb.uri}") String connectionString) {
		return MongoClients.create(connectionString);
	}
}