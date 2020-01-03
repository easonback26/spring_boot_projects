package com.sincere.candy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CandyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandyApplication.class, args);
		//ApplicationContext context = (ApplicationContext) SpringApplication.run(CandyApplication.class, args);


//		String[] beans = context.getBean();
//		for (int i = 0; i<beans.length; i++){
//			System.out.println(beans[i]);
//		}
	}
}
