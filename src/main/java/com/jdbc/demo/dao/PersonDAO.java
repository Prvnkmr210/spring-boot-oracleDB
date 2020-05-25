package com.jdbc.demo.dao;

import java.util.List;

import com.jdbc.demo.models.Person;

public interface PersonDAO {
	
	void insertEmployee();
	void insertEmployees(List<Person> persons);
	List<Person> getAllEmployees();
	Person getEmployeeById(String empId);
	
}
