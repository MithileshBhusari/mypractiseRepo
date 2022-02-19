package com.mtb.hystrixex.bookMyShow.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixD
public class BookMyShowApplication {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(groupKey = "mtb",commandKey = "mtb",fallbackMethod = "bookMyShowFallback")
	@GetMapping("bookShow")
	public String bookShow(){
		String emailServiceResponse = restTemplate.getForObject("http://localhost:8181/emailService/send", String.class);
		String paymentServiceResponse=restTemplate.getForObject("http://localhost:8282/paymentService/pay",String.class);
		return emailServiceResponse+"\n"+paymentServiceResponse;
	}

	@GetMapping("/bookShowWithoutFallback")
	public String bookShowWithoutFallback(){
		String emailServiceResponse = restTemplate.getForObject("http://localhost:8181/emailService/send", String.class);
		String paymentServiceResponse=restTemplate.getForObject("http://localhost:8282/paymentService/pay",String.class);
		return emailServiceResponse+"\n"+paymentServiceResponse;
	}

	public String bookMyShowFallback(){
		return "Service Gateway Failed...!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}
}
