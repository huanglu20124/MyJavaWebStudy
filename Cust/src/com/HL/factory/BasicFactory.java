package com.HL.factory;

import java.io.FileReader;
import java.util.Properties;

import org.junit.Test;

import sun.security.jca.GetInstance;

import com.HL.dao.CustDao;

public class BasicFactory {
	private BasicFactory(){
		
	}
	private static BasicFactory factory = new BasicFactory();
	private static Properties properties = null;
	
	public static BasicFactory getFactory(){
		return factory;
	}
	
	static{
		try {
			properties = new Properties();
			properties.load(new FileReader(BasicFactory.class.
					getClassLoader().getResource("config.properties").getPath())); 	
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//·ºÐÍ
	public  <T> T getInstance(Class<T> clazz){
		try {
			String cname = clazz.getSimpleName();
			String cImplName = properties.getProperty(cname);
			//±ÜÃâÇ¿×ª
//			String xString = Class.forName(cImplName).toString();
//            System.out.println("xxx");
//            T clazz2=(T) Class.forName(cImplName).newInstance();

			return (T) Class.forName(cImplName).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
