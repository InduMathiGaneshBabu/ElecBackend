package com.electronics.Dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.model.Cart;
import com.electronics.model.OrderDetail;

@Repository("orderDao")
@Transactional
public class OrderDetailImpl implements OrderDetailDao
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean PaymentProcess(OrderDetail orderdetail) 
	{
		try
		{
		sessionfactory.getCurrentSession().save(orderdetail);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Error occured"+e);
			return false;
		}
	}

	@Override
	public boolean UpdateCartItemStatus(String username) 
	{
		try
		{
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("update Cart set status='P' where username=:uname");
		query.setParameter("uname", username);
		int row_eff=query.executeUpdate();
		
		if(row_eff>0)
			
		     return true;
		else
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured"+e);
			return false;
		}
	}

}
