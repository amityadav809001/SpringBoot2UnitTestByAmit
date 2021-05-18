package com.amit.service;

import java.util.List;

import com.amit.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee e);

	public List<Employee> getAllEmployee();

	public Employee getOneEmployee(Integer id);
}
