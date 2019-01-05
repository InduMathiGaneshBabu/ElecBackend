package com.electronics.Dao;
import java.util.List;

import com.electronics.model.Product;

public interface ProductDao
{
 public boolean addProduct(Product product);
 public boolean updateProduct(Product product);
 public boolean deleteProduct(Product product);
 public List<Product> listproducts();
 public Product getProduct(int productid);
 
}
