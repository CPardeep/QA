package com.qa.config;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration 
public class AppConfig {
	@Bean 
	public static String helloBean() {
		return "hello bean";
	}
	
	@Bean
    public String greeting() {
        return "Hello, World";
    }

	@Bean //By default if you use this, it will be a singleton bean which mean it can be only created once. 
	@Scope("prototype") //When you specify the bean to prototype, farewell will be created everytime it is accessed. 
	public static String farewell() {
		return "BYE BYE";
	}
	@Bean
    public String date() {
        return LocalTime.now().toString();
    }
	@Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
