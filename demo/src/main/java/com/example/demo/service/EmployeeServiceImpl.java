package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> listEmployees()
	{
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
		
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	

	public String deleteEmployee(Employee emp){
		String msg="EMployee not found";
		try{
			employeeRepository.delete(emp);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return msg;
	}
	
	
	@Override
	public Employee findById( Employee employee) {
		Optional<Employee> opt=employeeRepository.findById(employee.getEid());
		Employee e=opt.get();
		return e;
	}

	@Override
	public List<Employee> findByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
		
	
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findByDeptNo(int deptNo) {
		return employeeRepository.findByDeptNo(deptNo);
	}

	

}
