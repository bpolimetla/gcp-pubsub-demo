package com.gcp.demo.greeting;

import java.util.concurrent.atomic.AtomicLong;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcp.demo.DemoApplication;
import com.gcp.demo.DemoApplication.PubsubOutboundGateway;

//https://spring.io/guides/gs/rest-service/

@RestController
public class GreetingController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PubsubOutboundGateway messagingGateway;

	// http://localhost:8080/greeting?name=User

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		LOGGER.info("Sending to topic: " + name);
		// send the name to pubsub
		messagingGateway.sendToPubsub(name);

		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
