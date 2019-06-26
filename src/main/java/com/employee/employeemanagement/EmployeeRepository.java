package com.employee.employeemanagement;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Integer> {

	void delete(Employee user);

	List<Employee> findAll();

	Employee findOne(int id);

	Employee save(Employee user);

	Employee findByEmail(String email);
}
