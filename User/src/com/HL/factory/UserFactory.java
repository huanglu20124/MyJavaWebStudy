package com.HL.factory;

import java.io.FileReader;
import java.util.Properties;

import com.HL.dao.UserDao;


public class UserFactory {
	private static UserFactory factory = new UserFactory();
	private static Properties prop = null;
	static{
		try{
			prop = new Properties();
			prop.load(new FileReader(UserFactory.class.getClassLoader().getResource("config.properties").getPath()));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private UserFactory() {
	}
	
	public static UserFactory getFactory(){
		return factory;
	}
	
	public UserDao getDao(){
		try{
			String clazz = prop.getProperty("userDao");
			return  (UserDao) Class.forName(clazz).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
