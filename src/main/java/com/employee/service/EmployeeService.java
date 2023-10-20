package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;

	public String setAll(List<Employee> a) {
		
		return ed.setAll(a);
	}

	public List<Employee> getAll() {
		
		return ed.getAll();
	}

	public Employee findByIds(int a)throws IdNotFoundException {
		
		
		return ed.findByIds(a);
	}

	public String setAllNew(List<Employee> a)throws SalaryNotValidException {
		
		List<Employee>bb=a.stream().filter(x->x.getSalary()>50000).toList();
		if(bb.isEmpty()) {
			throw new SalaryNotValidException("no valid salary present");
		}
		else {
			return ed.setAllNew(bb);

		}
	}

	public String setOne(Employee a) {
		return ed.setOne(a);
	}
	

}
