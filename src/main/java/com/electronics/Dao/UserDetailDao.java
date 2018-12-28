package com.electronics.Dao;

import com.electronics.model.UserDetail;

public interface UserDetailDao 
{
public boolean registerUser(UserDetail userdetail);
public boolean updateUser(UserDetail userdetail);
public UserDetail getuserdetail(String username);
}
