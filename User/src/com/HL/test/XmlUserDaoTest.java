package com.HL.test;

import org.junit.Test;

import com.HL.dao.XmlUserDao;
import com.HL.domain.User;

public class XmlUserDaoTest {
	@Test
	public void testFindUserByUserName(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUserName("admin");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByNMandPSW(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUNandPSW("admin", "admin");
		System.out.println(user);
	}
	
	@Test
	public void testAddUser(){
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUsername("ÆÓÇ¬");
		user.setPassword("123");
		user.setNickname("Ð¡ÆÓÆÓ");
		user.setEmail("piaoqian@itcast.cn");
		dao.addUser(user);
	}
}
