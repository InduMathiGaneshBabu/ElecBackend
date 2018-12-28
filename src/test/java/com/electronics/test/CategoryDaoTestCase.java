package com.electronics.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.electronics.Dao.CategoryDao;
import com.electronics.model.Category;

public class CategoryDaoTestCase 

{
	static CategoryDao categoryDao;
	
	
     @BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.electronics");
		context.refresh();
		categoryDao=(CategoryDao)context.getBean("categoryDao");
	}
     @Ignore
     @Test
     public void addCategoryTestCase()
     {
    	 Category category=new Category();
    	 category.setCategoryname("Door curtain");
    	 category.setCategorydesc("All varieties of curtains are avilable");
    	 assertTrue("problem in adding the category",categoryDao.addCategory(category));
     }
     @Ignore
     @Test 
     public void updateCategoryTestCase()
     {
    	 
      Category category=categoryDao.getCategory(195);
      category.setCategorydesc("hjij");
      assertTrue("problem in updating a category",categoryDao.updateCategory(category));
     }
     @Ignore
     @Test
     public void deleteCategoryTestCase()
     {
    	Category category=categoryDao.getCategory(65);
    	assertTrue("problem in deleting the category",categoryDao.deleteCategory(category));
    	
     }
     @Ignore
     @Test
     public void listcategory()
     {
    	 List<Category> listcategory=categoryDao.listcategory();
    	 assertTrue("problem in listing the category",categoryDao.listcategory().size()>0);
    	 for(Category category:listcategory)
    	 {
    		 System.out.print(category.getCategoryid()+":::");
    		 System.out.print(category.getCategoryname()+":::");
    		 System.out.println(category.getCategorydesc());
    	 }
     }
}
