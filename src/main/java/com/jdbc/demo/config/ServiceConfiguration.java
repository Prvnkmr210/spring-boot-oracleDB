package com.jdbc.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.demo.dao.PersonDAO;
import com.jdbc.demo.daoImpl.PersonDAOImplSelfDI;

@Configuration
public class ServiceConfiguration {
	
	@Bean (name = "oracleDataSource")
	public DataSource getOracleDataSource(){
		DataSourceBuilder dataSourcebuilder = DataSourceBuilder.create();
		dataSourcebuilder.url("jdbc:oracle:thin:@//localhost:1521/orcl");
		dataSourcebuilder.username("hr");
		dataSourcebuilder.password("hr12");
		return dataSourcebuilder.build();
	}
	
	@Bean (name = "jdbcTemplate")
	public JdbcTemplate getJdbc() {
		return new JdbcTemplate(getOracleDataSource());
	}
	
	@Bean (name = "PersonDAOSelfDI")
	public PersonDAOImplSelfDI getPersonDAO() {
		PersonDAOImplSelfDI persondao = new PersonDAOImplSelfDI();
		persondao.setJdbc(getJdbc());
		return persondao;
	}

}
