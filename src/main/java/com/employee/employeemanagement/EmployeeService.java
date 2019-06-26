package com.employee.employeemanagement;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {

    HashMap<String, String> create(Employee user);

    Employee delete(int id);

    List<Employee> findAll();

    Employee findById(int id);
    
    Employee findByEmail(String email);


    HashMap<String, String> update(Employee user);
}
