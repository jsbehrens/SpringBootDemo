package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);}

//		@Bean
//		public String message(){
//			System.out.println("message bean created.");
//			return "Hello, Spring!";
//		}
//
//		@Bean
//		public String uppercaseMessage(MessageService msgService){
//			System.out.println("uppercase message bean created.");
//			return msgService.uppercase();
//		}
//
//		@Bean
//		public String lowercaseMessage(MessageService msgService){
//			System.out.println("lowercase message bean created.");
//			return msgService.lowercase();
//	}
}