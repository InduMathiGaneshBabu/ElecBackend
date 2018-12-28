package com.electronics.Dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.model.Category;
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao
{
@Autowired
 SessionFactory sessionfactory;
	@Override
	public boolean addCategory(Category category) 
	{
		try
		{
	sessionfactory.getCurrentSession().save(category);
	return true;
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean deleteCategory(Category category) 
	{
		try
		{
	sessionfactory.getCurrentSession().delete(category);
	return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean updateCategory(Category category) 
	{
		sessionfactory.getCurrentSession().update(category);
		return true;
	}

	@Override
	public List<Category> listcategory()
	{
		Session session=sessionfactory.openSession();
		Query<Category> query=session.createQuery("from Category");
		List<Category> listcategory=query.list();
		session.close();
		return listcategory;
		
		
	}

	@Override
	public Category getCategory(int categoryid) 
	{
		Session session=sessionfactory.openSession();
		Category category=(Category)session.get(Category.class,categoryid);
		session.close();
		return category;
	}

}
