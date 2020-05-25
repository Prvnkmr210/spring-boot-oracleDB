package com.jdbc.demo.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.demo.dao.PersonDAO;
import com.jdbc.demo.models.Person;

public class PersonDAOImplSelfDI implements PersonDAO{
	
	JdbcTemplate jdbc;
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public void insertEmployee() {
		String insertSQL = "INSERT INTO PERSONS (PERSONID, CITY, FIRSTNAME, LASTNAME) VALUES (5875, 'London', 'Amy', 'Jackson')";
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
