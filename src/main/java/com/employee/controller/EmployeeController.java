package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@PostMapping("/setall")
	public String setAll(@RequestBody List<Employee> a) {
		return es.setAll(a);
	}
	
	@PostMapping("/setone")
	public String setOne(@PathVariable Employee a) {
		return es.setOne(a);
	}
	
	
	
	
	
	@GetMapping("/getall")
	public List<Employee>  getAll() {
		return es.getAll();
	}
	
	@GetMapping("/findbyid/{a}")
	public Employee  findByIds(@PathVariable int a)throws IdNotFoundException {
		return es.findByIds(a);
	}
	
	
	@PostMapping("/setallnew")
	public String setAllNew(@RequestBody List<Employee> a)throws SalaryNotValidException {
		return es.setAllNew(a);
	}
	
	
	

}
