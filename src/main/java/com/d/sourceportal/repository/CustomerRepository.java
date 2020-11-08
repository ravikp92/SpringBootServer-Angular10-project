package com.d.sourceportal.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.d.sourceportal.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
 List<Customer> findByAge(int age);
}
