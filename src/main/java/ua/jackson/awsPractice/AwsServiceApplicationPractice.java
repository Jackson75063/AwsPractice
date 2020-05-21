package ua.jackson.awsPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AwsServiceApplicationPractice {
	public static void main(String[] args)  {
		SpringApplication.run(AwsServiceApplicationPractice.class, args);
		
		print()
	}
	
	
	
	public static void print() throws Throwable {

		System.out.println("Hello");
		throw new Throwable("Hello from excep");
	}
}

