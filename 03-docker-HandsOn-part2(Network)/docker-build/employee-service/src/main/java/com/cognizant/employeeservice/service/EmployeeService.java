package com.cognizant.employeeservice.service;

import java.util.List;

import com.cognizant.employeeservice.exception.EmployeeNotFoundException;
import com.cognizant.employeeservice.models.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int emp_id) throws EmployeeNotFoundException;
	public Employee updateEmployeeDetails(int emp_id,Employee employee) throws EmployeeNotFoundException;
	public Employee addEmployee(Employee employee);
	public void deleteEmployee(int emp_id) throws EmployeeNotFoundException;
}
