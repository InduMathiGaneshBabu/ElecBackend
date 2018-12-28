package com.electronics.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.model.UserDetail;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDetailDao
{
    @Autowired
    SessionFactory sessionfactory;
	@Override
	public boolean registerUser(UserDetail userdetail) 
	{
		sessionfactory.getCurrentSession().save(userdetail);
		return true;
	}

	@Override
	public boolean updateUser(UserDetail userdetail)
	{
		sessionfactory.getCurrentSession().update(userdetail);
		return true;
	}

	@Override
	public UserDetail getuserdetail(String username)
	{
	Session session=sessionfactory.openSession();
	UserDetail userdetail=(UserDetail)session.get(UserDetail.class,username);
	session.close();
	return userdetail;
	}
   
}
