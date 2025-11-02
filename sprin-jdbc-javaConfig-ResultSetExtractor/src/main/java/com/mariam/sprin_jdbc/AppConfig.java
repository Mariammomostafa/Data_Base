package com.mariam.sprin_jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.mariam")
public class AppConfig {

	@Bean
	public JdbcTemplate jdbcTemplate() {

		return new JdbcTemplate(dataSource());
	}

	
	@Bean
	public DataSource dataSource() {

		String url = "jdbc:mysql://localhost:3306/spring_jdbc";
		String username = "root";
		String password = "root";
		DataSource dataSource = new DriverManagerDataSource(url, username, password);

		return dataSource;
	}

}
