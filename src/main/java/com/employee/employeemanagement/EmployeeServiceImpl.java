package com.employee.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public HashMap<String, String> create(Employee user) {
		HashMap<String, String> map = new HashMap<String, String>();
		Employee users = findByEmail(user.getEmail());
		if (users != null) {
			map.put("Message", "The Employee Is Already Added In Our Database");
			return map;
		} else {
			repository.save(user);
		}
		return map;
	}

	@Override
	public Employee delete(int id) {
		Employee user = findById(id);
		if (user != null) {
			repository.delete(user);
		}
		return user;
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return repository.findOne(id);
	}

	@Override
	public HashMap<String, String> update(Employee user) {
		HashMap<String, String> map = new HashMap<String, String>();
		Employee users = findById(user.getId());
		if (users != null) {
			if (user.getEmail() != null) {
				users.setEmail(user.getEmail());
			}
			if (user.getFirstName() != null) {
				users.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				users.setLastName(user.getLastName());
			}
			repository.save(users);
			map.put("Message", "" + "Employee Is Updated");
			return map;
		} else {
			map.put("Message", "Employee is not in databse");
		}
		return map;
	}

	@Override
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}
}
