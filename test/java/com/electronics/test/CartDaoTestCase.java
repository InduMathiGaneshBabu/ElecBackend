package com.electronics.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.electronics.Dao.CartDao;
import com.electronics.model.Cart;

public class CartDaoTestCase 
{
   static CartDao cartDao;
   @BeforeClass
   public static void executeFirst()
   {
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("com.electronics");
	   context.refresh();
	   cartDao=(CartDao)context.getBean("cartDao");
	   
   }
	@Ignore
   @Test
   public void addToCartTestCase()
   {
	   Cart cart=new Cart();
	   cart.setCartid(34);
	   cart.setProductid(23);
	   cart.setProductname("switch board");
	   cart.setPrice(200);
	   cart.setQuantity(4);
	   cart.setStatus("N");
	   cart.setUsername("indu");
	   assertTrue("Problem in adding the cart",cartDao.addToCart(cart));
	   
   }
	@Ignore
   @Test
   public void deleteItemfromCartTestCase()
   {
	   Cart cart=cartDao.getCartItem(56);
	   assertTrue("Problem in deleting the cart items",cartDao.deleteItemFromCart(cart));
   }
	@Ignore
	@Test
	public void UpdateCartTestCase()
	{
		Cart cart=cartDao.getCartItem(35);
		cart.setProductname("massager");
		assertTrue("Problem in updating the cart",cartDao.updateCartItem(cart));
	}
	@Ignore
	@Test
	public void listcartTestCase()
	{
		List<Cart> listcartitem=cartDao.listCartItems("indu");
		assertTrue("problem in listing the cart",cartDao.listCartItems("babu").size()>0);
		for(Cart cart:listcartitem)
		{
			System.out.print(cart.getCartid()+":::");
			System.out.print(cart.getProductid()+":::");
			System.out.print(cart.getProductname()+":::");
			System.out.print(cart.getPrice()+":::");
			System.out.print(cart.getUsername()+":::");
			System.out.print(cart.getStatus()+"::::");
			System.out.println(cart.getQuantity());
		}
	}
}
	
	

