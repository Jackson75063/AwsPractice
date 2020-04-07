package ua.jackson.awsPractice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AwsServiceApplicationPractice {

	public static void main(String[] args)  {

		List<Integer> a1 = Arrays.asList(1,2,3,5);
		List<Integer> a2 = Arrays.asList(1,2,3);

		System.out.println(a1.containsAll(a2));

		SpringApplication.run(AwsServiceApplicationPractice.class, args);

	}
}

