package com.amit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.exception.EmployeeNotFoundException;
import com.amit.model.Employee;
import com.amit.repo.EmployeeRepository;
import com.amit.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee e) {
		// TODO Auto-generated method stub

		return repo.save(e).getEmpId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		
		
		return repo.findById(id).orElseThrow(
				()-> new EmployeeNotFoundException("Employee Not Exist"));
		// TODO Auto-generated method stub
		/*
		 * Optional<Employee> opt = repo.findById(id);
		 * 
		 * if (opt.isPresent()) return opt.get(); else throw new
		 * EmployeeNotFoundException("Employee Not Exist");
		 */
	}

}
