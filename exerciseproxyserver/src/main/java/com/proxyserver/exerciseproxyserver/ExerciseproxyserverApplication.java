package com.proxyserver.exerciseproxyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.proxyserver.exerciseproxyserver.filters.*;

@SpringBootApplication
@EnableZuulProxy // Zuul proxy Reference
public class ExerciseproxyserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseproxyserverApplication.class, args);
	}
	
	@Bean
	public postFilter postFilter() {
		return new postFilter();
	}
}
