package com.HL.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	private DaoUtils(){
		
	}

	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
