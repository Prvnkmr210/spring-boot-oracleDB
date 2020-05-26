package com.jdbc.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.demo.dao.PersonDAO;
import com.jdbc.demo.daoImpl.PersonDAOImplSelfDI;
import com.jdbc.demo.daoImpl.PersonDAOImplSelfDIMySQL;

@Configuration
public class ServiceConfiguration {
	
	@Bean (name = "oracleDataSource")
	public DataSource getOracleDataSource(){
		DataSourceBuilder dataSourcebuilder = DataSourceBuilder.create();
		dataSourcebuilder.url("jdbc:oracle:thin:@//localhost:1521/orcl");
		dataSourcebuilder.username("hr");
		dataSourcebuilder.password("hr12");
		dataSourcebuilder.driverClassName("oracle.jdbc.OracleDriver");
		return dataSourcebuilder.build();
	}
	
	@Bean (name = "Oracle_jdbcTemplate")
	public JdbcTemplate getOracleJdbc() {
		return new JdbcTemplate(getOracleDataSource());
	}
	
	@Bean (name = "PersonDAOSelfDI")
	public PersonDAO getPersonDAOSelfDI() {
		PersonDAO persondao = new PersonDAOImplSelfDI();
		persondao.setJdbc(getOracleJdbc());
		return persondao;
	}
	
	@Bean (name = "MySQLDataSource")
	public DataSource getMySQLDataSource(){
		DataSourceBuilder dataSourcebuilder = DataSourceBuilder.create();
		dataSourcebuilder.url("jdbc:mysql://localhost:3306/testmysqldb");
		dataSourcebuilder.username("root");
		dataSourcebuilder.password("leetcode@3");
		dataSourcebuilder.driverClassName("com.mysql.jdbc.Driver");
		return dataSourcebuilder.build();
	}
	
	@Bean (name = "MySql_jdbcTemplate")
	public JdbcTemplate getMySQLJdbc() {
		return new JdbcTemplate(getMySQLDataSource());
	}
	
	@Bean (name = "PersonDAOSelfDIMySQL")
	public PersonDAO getPersonDAOSelfDIMySQL() {
		PersonDAO persondao = new PersonDAOImplSelfDIMySQL();
		persondao.setJdbc(getMySQLJdbc());
		return persondao;
	}
	
	@Bean (name = "H2inMemDataSource")
	@Primary
	public DataSource getH2inMemDataSource(){
		DataSourceBuilder dataSourcebuilder = DataSourceBuilder.create();
		//dataSourcebuilder.url("jdbc:h2:mem:testdb");
		dataSourcebuilder.url("jdbc:h2:file:C:/data/newh2file;MV_STORE=FALSE");
		// http://www.h2database.com/html/main.html
		//dataSourcebuilder.url("jdbc:h2:C:/data/h2file");
		dataSourcebuilder.username("sa");
		dataSourcebuilder.password("");
		dataSourcebuilder.driverClassName("org.h2.Driver");
		return dataSourcebuilder.build();
	}
	
	@Bean (name = "H2DB_jdbcTemplate")
	public JdbcTemplate getH2jdbc() {
		return new JdbcTemplate(getH2inMemDataSource());
	}

}
