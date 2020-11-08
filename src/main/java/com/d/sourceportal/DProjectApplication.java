package com.d.sourceportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.d.sourceportal.controller.CustomerController;
import com.d.sourceportal.model.Customer;
import com.d.sourceportal.repository.CustomerRepository;
@SpringBootApplication
public class DProjectApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DProjectApplication.class, args);
	}
}
