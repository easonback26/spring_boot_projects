package com.example.SpringAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Tutorial from : https://www.youtube.com/watch?v=5zUTc-kge8I&t=209s     https://www.youtube.com/watch?v=VIaBbNaYDaU
 *
 * More Resource:
 * What is a Spring Bean: https://www.baeldung.com/spring-bean
 * Guide to Spring @AutoWired : https://www.baeldung.com/spring-autowire
 *
 * How to stop debug logs: https://mkyong.com/spring-boot/spring-boot-test-how-to-stop-debug-logs/
 */

//Spring Core Annotation
public class SpringAnnoApplication {

	public static void main(String[] args) {

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		Samsung s7 = factory.getBean(Samsung.class);
		s7.config();
	}

}
