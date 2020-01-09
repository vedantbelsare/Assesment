package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long>{

	List<Employee> findByDesignation(String designation);
	List<Employee> findByName(String name);
	List<Employee> findByDeptNo(int deptNo);
}
