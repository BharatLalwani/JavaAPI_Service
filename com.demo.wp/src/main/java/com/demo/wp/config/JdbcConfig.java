package com.demo.wp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value="application.properties")
public class JdbcConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getDataSource() {
	     DriverManagerDataSource dataSource = new DriverManagerDataSource();
	     
	    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	     
	     dataSource.setUrl(env.getProperty("spring.datasource.url"));
	     dataSource.setUsername(env.getProperty("spring.datasource.username"));
	     dataSource.setPassword(env.getProperty("spring.datasource.password"));
	     
	   //  try {
	//		Connection conn = DriverManager.getConnection("jdbc:sqlserver://AUUR02VP0322\\SQLEXPRESS:1433;databaseName=HLC2","CORPAU\\l095743","Bunty@123");
	//		return (DataSource) conn;
	//	} catch (SQLException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//		return null;
	//	}

	    	 return dataSource;    
	 }
	
	 @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}