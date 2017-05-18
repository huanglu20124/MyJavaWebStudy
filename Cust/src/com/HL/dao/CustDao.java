package com.HL.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.HL.domain.Customer;
import com.HL.domain.Page;

public interface CustDao {

	Object isFindUserByName(String name);

	void addCust(Customer customer);
	
	List<Customer> getAllCust();
	
	 Customer findCustById(String id);
	void updateCust(Customer customer);
	
	void delCust(String id);
	
	void delCustForBatch(Connection connection,String id) throws SQLException;
	
	List<Customer> findCustQueryOne(Customer customer);
	
	List<Customer> getPage(int thispage, int rowperpage);
	
	int getCountRow();

}
