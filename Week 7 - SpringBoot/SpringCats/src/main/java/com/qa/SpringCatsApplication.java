package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCatsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCatsApplication.class, args);
		
		System.out.println(context.getBean("helloBean", String.class));
		System.out.println(context.getBean("greeting", String.class));
		System.out.println(context.getBean("farewell", String.class));
		System.out.println(context.getBean("date", String.class));

		
		
	}

}
