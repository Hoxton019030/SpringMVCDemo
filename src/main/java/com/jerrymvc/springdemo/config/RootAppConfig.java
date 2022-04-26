package com.jerrymvc.springdemo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement   // or <tx:annotation-driven />
public class RootAppConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan("com.jerrymvc.springdemo.model");
		return sessionFactory;

	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}

	public HikariDataSource datasource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=SpringMvcDB");
		config.setUsername("Hoxton");
		config.setPassword("orz93098");
		config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		config.setMaximumPoolSize(5);
		config.setAutoCommit(false);
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2016Dialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
//		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

}
