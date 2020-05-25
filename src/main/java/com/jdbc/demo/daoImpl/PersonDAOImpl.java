package com.jdbc.demo.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdbc.demo.dao.PersonDAO;
import com.jdbc.demo.models.Person;

@Service
//annotation means Spring will auto inject this class wherever required. It will create an object and store in its context.
public class PersonDAOImpl implements PersonDAO{
	
	@Autowired
	JdbcTemplate jdbc;
	
//	@PostConstruct
//	  private void postConstruct() {
//	      jdbcTemplate = new JdbcTemplate(dataSource);
//	  }

	@Override
	public void insertEmployee() {
		String insertSQL = "INSERT INTO PERSONS (PERSONID, CITY, FIRSTNAME, LASTNAME) VALUES (5875, 'London', 'Amy', 'Jackson')";
		jdbc.execute(insertSQL);
		//jdbcTemplate.update(insertSQL);
		
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
