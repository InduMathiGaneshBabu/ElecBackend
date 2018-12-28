package com.electronics.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.electronics.model.OrderDetail;
import com.electronics.model.Cart;
import com.electronics.model.Category;
import com.electronics.model.Product;
import com.electronics.model.Supplier;
import com.electronics.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.electronics")
public class DBConfig
{

	@Bean(name="datasource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/h2 workspace");
		dataSource.setUsername("indu");
		dataSource.setPassword("indu");
		System.out.println("---DataSource Object is Created----");
		return dataSource;
	}
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		hibernateprop.put("hibernate.hbm2ddl.auto","update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateprop);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Cart.class);
		factory.addAnnotatedClass(OrderDetail.class);
		System.out.println("---SessionFactory Object  Created ----");
		return factory.buildSessionFactory();
		
		}
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager object Created--");
		return new HibernateTransactionManager(sessionFactory);
	}


}
