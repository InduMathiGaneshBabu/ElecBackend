package com.electronics.Dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.model.Product;
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao
{

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addProduct(Product product) {
		try
		{
			sessionfactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try
		{
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}

	@Override
	public boolean deleteProduct(Product product) {
		try
		{
			sessionfactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Product> listproducts() 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listproducts=query.list();
		session.close();
		return listproducts;
		
	}

	@Override
	public Product getProduct(int productid) 
	{
		Session session=sessionfactory.openSession();
		Product product=(Product)session.get(Product.class,productid);
		session.close();
		return product;
		
	}

}
