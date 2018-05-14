package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;

public class Demo01Test {
	@Test
	public void Test1() throws Exception {
		String resources="SqlMapConfig.xml";
		InputStream in=Demo01Test.class.getClassLoader().getResourceAsStream(resources);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		IUserDao userDao=session.getMapper(IUserDao.class);
		List<User> users=userDao.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
		in.close();
				
	}

}
