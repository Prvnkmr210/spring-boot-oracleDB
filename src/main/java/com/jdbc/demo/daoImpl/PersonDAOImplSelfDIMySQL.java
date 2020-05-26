package com.jdbc.demo.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.demo.dao.PersonDAO;
import com.jdbc.demo.models.Person;

public class PersonDAOImplSelfDIMySQL implements PersonDAO{
	
	public JdbcTemplate jdbc;
	
	@Override
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		
	}

	@Override
	public void insertEmployee() {
		String insertSQL = "insert into testmysqldb.person (pid,name) values (1235,'Naveen')";
		jdbc.execute(insertSQL);
		
	}

	@Override
	public void insertEmployees(List<Person> persons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}	

}
