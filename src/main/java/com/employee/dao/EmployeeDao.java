package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.customexception.IdNotFoundException;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;

	public String setAll(List<Employee> a) {
		
		er.saveAll(a);
		return "Posted all successfully"; 
	}

	public List<Employee> getAll() {
		return er.findAll();
	}

	public Employee findByIds(int a)throws IdNotFoundException {
		
		return er.findById(a).orElseThrow(()->new IdNotFoundException("Not Valid") );
	}

	public String setAllNew(List<Employee> a) {
		 er.saveAll(a);
		 return "posted all successfully";
	}

	

	public String setOne(Employee a) {
		
		er.save(a);
		
		return "posted one successfully";
	}

}
