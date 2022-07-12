package br.com.alticciservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AlticciServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlticciServiceApplication.class, args);
	}

}
