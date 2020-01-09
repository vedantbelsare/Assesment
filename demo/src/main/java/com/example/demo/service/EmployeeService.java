package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Employee;

@Service("employeeService")
public interface EmployeeService {
	
	public List<Employee> listEmployees();

	public Employee addNewEmployee( Employee employee);
	public Employee updateEmployee(Employee employee);
	
	public  Employee findById(Employee employee);
	public  List<Employee> findByDesignation(String designation);
	public  List<Employee> findByName(String name);
	public  List<Employee> findByDeptNo(int deptNo);
	public String deleteEmployee(Employee e);

}
