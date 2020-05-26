package com.jdbc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class H2DBController {
	
	@Autowired
	@Qualifier("H2DB_jdbcTemplate")
	JdbcTemplate jdbc;
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello, How are you.";
	}
	
	@RequestMapping(path = "/addCity", method = RequestMethod.GET)
	public String addCity() {
		try {
			jdbc.execute("INSERT INTO CITY (city_name,city_pincode) VALUES ('Patna', 801118)");
			return "success";
		}catch(Exception ex){
			return "fail " + ex.getMessage();
		}
		
	}

}
