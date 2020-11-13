package com.d.sourceportal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d.sourceportal.exception.ResourceNotFoundException;
import com.d.sourceportal.model.Employees;
import com.d.sourceportal.repository.EmployeeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EmployeesController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/employees")
	public List<Employees> getAllEmployees() {
		System.out.println("Get all Employees...");

		List<Employees> employees = new ArrayList<>();
		repository.findAll().forEach(employees::add);

		return employees;
	}

	@PostMapping(value = "/employees")
	public Employees postEmployee(@RequestBody Employees employee) {

		Employees savedEmployee = repository.save(employee);
		
		System.out.println("Saved  Employee..."+savedEmployee);
		return savedEmployee;
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employees> getEmployeeByid(@PathVariable("id") Long id) throws ResourceNotFoundException {
		Employees employee = repository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee Not exist iwth id :"+id));

		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable("id") long id) {
		
		System.out.println("Delete Employee with ID = " + id + "...");
		repository.deleteById(id);
		Map<String,Boolean> result=new HashMap<>();
		result.put("Deleted", true);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/employees/delete")
	public ResponseEntity<String> deleteAllEmployees() {
		System.out.println("Delete All Employees...");

		repository.deleteAll();

		return new ResponseEntity<>("All Employees have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "employees/email/{email}")
	public List<Employees> findByEMail(@PathVariable String email) {
		List<Employees> employees = repository.findByEmail((email));
		return employees;
	}
	@GetMapping(value = "employees/contact/{contact}")
	public List<Employees> findByContact(@PathVariable String contact) {
		List<Employees> employees = repository.findByContact((contact));
		return employees;
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable("id") long id, @RequestBody Employees employee) throws ResourceNotFoundException {
		System.out.println("Update Customer with ID = " + id + "...");

		Employees _employee = repository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee Not exist iwth id :"+id));
			_employee.setFirstName(employee.getFirstName());
			_employee.setLastName(employee.getLastName());
			_employee.setEmail(employee.getEmail());
			_employee.setContact(employee.getContact());
			Employees updatedEmployee=repository.save(_employee);
			return  ResponseEntity.ok(updatedEmployee);
	}
}