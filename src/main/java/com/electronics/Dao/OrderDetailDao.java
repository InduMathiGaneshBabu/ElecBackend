package com.electronics.Dao;

import com.electronics.model.OrderDetail;

public interface OrderDetailDao 
{
 public boolean PaymentProcess(OrderDetail orderdetail);
 public boolean UpdateCartItemStatus(String username);
}
