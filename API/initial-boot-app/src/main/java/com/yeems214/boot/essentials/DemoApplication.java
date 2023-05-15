package com.yeems214.boot.essentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	@RequestMapping("/api")
	public class ApiController {
		@RequestMapping("/greeting")
		public String getGreeting() {
			return "Hello World from the API!";
		}
	}

}
