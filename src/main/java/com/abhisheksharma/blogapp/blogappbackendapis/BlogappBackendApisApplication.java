package com.abhisheksharma.blogapp.blogappbackendapis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogappBackendApisApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlogappBackendApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
