package com.electronics.Dao;

import java.util.List;

import com.electronics.model.Category;

public interface CategoryDao 
{
	
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> listcategory();
	public Category getCategory(int categoryid);
	
}
