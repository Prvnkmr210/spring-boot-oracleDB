package com.jdbc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.demo.dao.PersonDAO;

@RestController
public class PersonControllerSelfDI {
	
	@Autowired
	@Qualifier("PersonDAOSelfDI")
	PersonDAO persondao;
	
	
	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	public String greet() {
		return "Hello, How can i help you";
	}
	
	@RequestMapping(path = "/savePerson", method = RequestMethod.GET)
	public String insertPerson() {
		try {
			persondao.insertEmployee();
			//jdbc.execute("INSERT INTO PERSONS (PERSONID, CITY, FIRSTNAME, LASTNAME) VALUES (5675, 'London', 'Amy', 'Jackson')");
			return "success";
		}catch(Exception e) {
			return "Failed " + e.getMessage();
		}
	}


}
