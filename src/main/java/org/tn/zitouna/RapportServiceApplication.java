package org.tn.zitouna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RapportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RapportServiceApplication.class, args);
	}

}
