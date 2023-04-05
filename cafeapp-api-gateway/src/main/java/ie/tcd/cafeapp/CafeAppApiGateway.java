package ie.tcd.cafeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CafeAppApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(CafeAppApiGateway.class, args);
	}

}