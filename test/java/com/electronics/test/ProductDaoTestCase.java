package com.electronics.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Ignore;

import com.electronics.Dao.ProductDao;
import com.electronics.model.Product;

public class ProductDaoTestCase
{

	static ProductDao productDao;
	
	   
		@BeforeClass
		public static void executeFirst()
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.electronics");
			context.refresh();
			productDao=(ProductDao)context.getBean("productDao");
			}
		@Ignore
		@Test
		public void addProductTestCase()
		{
			Product product=new Product();
			product.setProductname("shower cup");
			product.setProductdesc("bathing product");
			product.setPrice(35);
			product.setCategoryid("45");
			product.setStock(3);
			product.setSupplierid("45");
			assertTrue("problem in adding the product",productDao.addProduct(product));
		}
		@Ignore
		@Test
		public void updateProductTestCase()
		{
			Product product=productDao.getProduct(166);
			product.setProductdesc("Black in color");
			assertTrue("problem in updating the product",productDao.updateProduct(product));
		}
		@Ignore
		@Test
		public void deleteProductTestCase()
		{
			Product product=productDao.getProduct(167);
			assertTrue("problem in deleting the product",productDao.deleteProduct(product));
			
		}
		
		@Ignore
		@Test
		public void listproductsTestCase()
		{
		  List<Product> list=productDao.listproducts();
		  assertTrue("problem in listing the product",productDao.listproducts().size()>0);
		  for(Product product:list)
		  {
			  System.out.print("Product Id"+product.getProductid());
			  System.out.print("Product Name"+product.getProductname());
			  System.out.print("Product description"+product.getProductdesc());
			  System.out.print("Product Price"+product.getPrice());
			  System.out.print("Product stock"+product.getStock());
			  System.out.print("Category Id"+product.getCategoryid());
			  System.out.println("Supplier Id"+product.getSupplierid());
		  }
		}
		  
		 
		}
	

	












