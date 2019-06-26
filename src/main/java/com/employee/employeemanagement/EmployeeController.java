package com.employee.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/users" })
public class EmployeeController {

	@Autowired
	private EmployeeService userService;

	@PostMapping
	public HashMap<String, String> create(@RequestBody Employee user) {

		return userService.create(user);
	}

	@GetMapping(path = { "/{id}" })
	public Employee findOne(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@PutMapping
	public HashMap<String, String> update(@RequestBody Employee user) {
		user.setId(user.getId());
		return userService.update(user);
	}

	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") int id) {
		return userService.delete(id);
	}

	@GetMapping
	public List<Employee> findAll() {
		return userService.findAll();
	}
}
