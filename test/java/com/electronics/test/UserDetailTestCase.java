package com.electronics.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.electronics.Dao.UserDetailDao;
import com.electronics.model.UserDetail;

public class UserDetailTestCase
{

	static UserDetailDao userDao;
	
	@BeforeClass
	public static void ExecuteFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.electronics");
		context.refresh();
		
	userDao=(UserDetailDao)context.getBean("userDao");
	}
	@Ignore
	@Test
	public void registeruserTestCase()
	{
		UserDetail userdetail=new UserDetail();
		userdetail.setCustomername("Hema latha");
		userdetail.setUsername("hema");
		userdetail.setEmailid("hema1963@gmail.com");
		userdetail.setAddress("Ramnathapuram");
		userdetail.setMobileno("9788193808");
		userdetail.setPassword("hema");
		userdetail.setRole("user");
		userdetail.setEnabled(true);
		assertTrue("problem in registering the user",userDao.registerUser(userdetail));
		
	}
	@Ignore
	@Test
	public void updateuserTestcase()
	{
		UserDetail userdetail =(UserDetail)userDao.getuserdetail("Babu");
		userdetail.setPassword("ganesh");
		assertTrue("problem in updating the userdetail",userDao.updateUser(userdetail));
	}
	
	@Test
	public void listUserDetailTestCase()
	{
		List<UserDetail> listuserdetail=userDao.listuserdetail("Role_User");
		assertTrue("problem in listing the userdetail",userDao.listuserdetail("Role_User").size()>0);
		for(UserDetail userdetail:listuserdetail)
		{
			System.out.println(userdetail.getUsername());
			System.out.println(userdetail.getCustomername());
			System.out.println(userdetail.getAddress());
			System.out.println(userdetail.getEmailid());
			System.out.println(userdetail.getMobileno());
			System.out.println(userdetail.getPassword());
			System.out.println(userdetail.getRole());
			
			
		}
		
	}


}
