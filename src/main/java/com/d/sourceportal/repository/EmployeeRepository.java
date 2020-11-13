package com.d.sourceportal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.d.sourceportal.model.Employees;

public interface EmployeeRepository extends CrudRepository<Employees, Long> {
	List<Employees> findByEmail(String email);
	List<Employees> findByContact(String contact);
}
