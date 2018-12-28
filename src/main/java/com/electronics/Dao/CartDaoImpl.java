package com.electronics.Dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.model.Cart;
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao
{
      @Autowired()
      SessionFactory sessionfactory;
	@Override
	public boolean addToCart(Cart cart) 
	{
		try
		{
		sessionfactory.getCurrentSession().save(cart);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItemFromCart(Cart cart) 
	{
		try
		{
		sessionfactory.getCurrentSession().delete(cart);
	return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCartItem(Cart cart)
	{ 
		try
		{
		sessionfactory.getCurrentSession().update(cart);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Cart getCartItem(int cartid) 
	{
		Session session=sessionfactory.openSession();
		Cart cart=(Cart)session.get(Cart.class, cartid);
		session.close();
		return cart;
		
	}

	@Override
	public List<Cart> listCartItems(String username)
	{
	Session session=sessionfactory.openSession();
	Query query=session.createQuery("from Cart where username=:uname and status=:N");
	query.setParameter("uname",username);
	query.setParameter("N","N");
	List<Cart> listCartItems=query.list();
	session.close();
	return listCartItems;
	}

}
