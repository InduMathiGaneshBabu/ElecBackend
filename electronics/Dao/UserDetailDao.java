package com.electronics.Dao;

import java.util.List;

import com.electronics.model.UserDetail;

public interface UserDetailDao 
{
public boolean registerUser(UserDetail userdetail);
public boolean updateUser(UserDetail userdetail);
public UserDetail getuserdetail(String username);
public List<UserDetail> listuserdetail(String role);
}
