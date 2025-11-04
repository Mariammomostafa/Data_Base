package com.selenium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan("com.selenium")
public class StudentAppConfog implements WebMvcConfigurer{


	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
	    viewResolver.setViewClass(JstlView.class); // Use JstlView for JSTL support
	    
		return viewResolver;
	}
	
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/resources/**")
         .addResourceLocations("resources");
	}




	@Bean
	DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring-jpa-hibernate");
		dataSource.setPassword("root");
		dataSource.setUsername("root");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			
		return dataSource;
	}
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		
		return new JdbcTemplate(dataSource()); 
	}
}
