package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

public interface IUserDao {
	List<User> findAll();

}
