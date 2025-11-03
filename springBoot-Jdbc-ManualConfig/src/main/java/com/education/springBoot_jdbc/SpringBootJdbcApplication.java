package com.education.springBoot_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class , DataSourceAutoConfiguration.class})
public class SpringBootJdbcApplication implements CommandLineRunner{

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES(8 , 99 ,'maha')"); 
	}

}
