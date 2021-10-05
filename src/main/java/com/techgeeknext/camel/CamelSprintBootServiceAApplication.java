package com.techgeeknext.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan
@Configuration
@EnableAutoConfiguration
//@ImportResource("classpath:camel-context.xml")
@OpenAPIDefinition(info = @Info(title = "Camel Route API", version = "2.0", description = "Camel Route Information"))
public class CamelSprintBootServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelSprintBootServiceAApplication.class, args);
	}

}
