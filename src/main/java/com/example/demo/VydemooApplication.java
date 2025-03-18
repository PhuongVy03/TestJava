package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;

@SpringBootApplication
@EntityScan("com.example.demo.entity")
public class VydemooApplication {

	public static void main(String[] args) {
		SpringApplication.run(VydemooApplication.class, args);
		
	}
		
//	 @Bean
//	    CommandLineRunner initData(AddressRepository addressRepository) {
//	        return args -> {
//	            try {
//	            	addressRepository.deleteAll();
//	                List<String> provinces = Files.lines(Paths.get("src/main/resources/provinces.txt"))
//	                                              .collect(Collectors.toList());
//
//	                for (String province : provinces) {
//	                    Address address = new Address();
//	                    address.setAddress(province);
//	                    addressRepository.save(address);
//	                }
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        };
//	 }
}
