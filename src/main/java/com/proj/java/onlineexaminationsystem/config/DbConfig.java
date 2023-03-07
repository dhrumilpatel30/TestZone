package com.proj.java.onlineexaminationsystem.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

//@Configuration
public class DbConfig {

//	@Autowired
//	private Environment environment;
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
//		dataSource.setUrl(environment.getProperty("jdbc.url"));
//		dataSource.setUsername(environment.getProperty("jdbc.username"));
//		dataSource.setPassword(environment.getProperty("jdbc.password"));
//
//		return dataSource;
//	}
//
//	@Bean
//	public LocalSessionFactoryBean getSessionFactory() {
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//		factoryBean.setDataSource(dataSource());
//
//		Properties props = new Properties();
//		props.put("format_sql", "true");
//		props.put("hibernate.show_sql", "true");
//
//		factoryBean.setHibernateProperties(props);
//		factoryBean.setPackagesToScan("com.roytuts.spring.mvc.hibernate.crud.entity");
//		// factoryBean.setAnnotatedClasses(Teacher.class);
//		return factoryBean;
//	}
//
//	@Bean
//	public HibernateTransactionManager getTransactionManager() {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(getSessionFactory().getObject());
//		return transactionManager;
//	}

}
