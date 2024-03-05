package com.vk.jenkinp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkincicdApplication {

	@GetMapping("/greetings/{name}")
	public String greetings(@PathVariable String name){
		return "Hello " + name + " Greetings from Jenkins CI-CD Flow....";
	}

	public static void main(String[] args) {
		SpringApplication.run(JenkincicdApplication.class, args);
	}

}
