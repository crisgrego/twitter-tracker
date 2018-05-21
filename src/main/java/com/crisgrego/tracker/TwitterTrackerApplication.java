package com.crisgrego.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.crisgrego.tracker.controller.*;


@SpringBootApplication
public class TwitterTrackerApplication {
//	private static final Logger log = LoggerFactory.getLogger(TwitterTrackerApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterTrackerApplication.class, args);
	}
}