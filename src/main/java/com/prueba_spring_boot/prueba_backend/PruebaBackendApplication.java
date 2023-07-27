package com.prueba_spring_boot.prueba_backend;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PruebaBackendApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PruebaBackendApplication.class)
				.web(WebApplicationType.REACTIVE)
				.run(args);
	}
}
