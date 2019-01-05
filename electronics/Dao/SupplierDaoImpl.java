package com.electronics.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao 
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addsupplier(Supplier supplier) 
	{
		sessionfactory.getCurrentSession().save(supplier);
		return true;
	}

	@Override
	public boolean deletesupplier(Supplier supplier) 
	{
		sessionfactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Override
	public boolean updatesupplier(Supplier supplier)
	{
		sessionfactory.getCurrentSession().update(supplier);
		return true;
	}

	@Override
	public List<Supplier> listsupplier() 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listsupplier=query.list();
		session.close();
		return listsupplier;
	}

	@Override
	public Supplier getsupplier(int supplierid) 
	{
	Session session=sessionfactory.openSession();
	Supplier supplier=(Supplier)session.get(Supplier.class,supplierid);
	session.close();
	return supplier;
	}
	
	
	

}
