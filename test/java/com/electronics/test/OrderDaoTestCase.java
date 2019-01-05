package com.electronics.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.electronics.Dao.OrderDetailDao;
import com.electronics.model.OrderDetail;


public class OrderDaoTestCase 
{
	static OrderDetailDao orderDao;
	
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.electronics");
		context.refresh();
		
		orderDao=(OrderDetailDao)context.getBean("orderDao");
		
	}
		
	@Ignore
	@Test
	public void paymentprocessTest()
	{
		OrderDetail orderdetail=new OrderDetail();
		orderdetail.setUsername("babu");
		orderdetail.setOrderdate(new Date());
		orderdetail.setPmode("CC");
		orderdetail.setTotalshoppingamount(7800);
		
		assertTrue("problem in getting the order detail",orderDao.PaymentProcess(orderdetail));
		
	}
	@Ignore
    @Test
     public void UpdateCartItem()
     {
    
    	assertTrue("problem in updating the Cart",orderDao.UpdateCartItemStatus("babu"));
     }
	
	
	}


