package com.amit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
