package com.electronics.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.electronics.Dao.SupplierDao;
import com.electronics.model.Supplier;

public class SupplierTestCase
{

	static SupplierDao supplierDao;
	
	@BeforeClass
	public static void ExecuteFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.electronics");
		context.refresh();
		
	supplierDao=(SupplierDao)context.getBean("supplierDao");
	}
	
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierid(1);
		supplier.setSuppliername("Swathi");
		supplier.setSupplieraddr("Tiruchendur");
		assertTrue("problem in adding the supplier",supplierDao.addsupplier(supplier));
	}
   @Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=(Supplier)supplierDao.getsupplier(1355);
		assertTrue("problem in deleting the supplier",supplierDao.deletesupplier(supplier));
	}
	@Ignore
	@Test
	public void UpdateSupplierTest()
	{
		Supplier supplier=(Supplier)supplierDao.getsupplier(1356);
		supplier.setSupplieraddr("Rameshwaram");
		assertTrue("problem in updating the supplier",supplierDao.updatesupplier(supplier));
	}
	
	@Test
	public void  listsupplierTest()
	{
		List<Supplier> listsupplier	= supplierDao.listsupplier();
		assertTrue("problem in listing the supplier",supplierDao.listsupplier().size()>0);
		
		for(Supplier supplier:listsupplier)
		{
			System.out.println(supplier.getSuppliername()+"::::");
			System.out.print(supplier.getSupplieraddr());
		}
		
		
	}
	
}
