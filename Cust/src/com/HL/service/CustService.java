package com.HL.service;

import java.util.List;

import com.HL.domain.Customer;
import com.HL.domain.Page;

public interface CustService {


	/*ÃÌº””√ªß
	 * 
	 */
	void addCust(Customer customer);

	List<Customer> getAlllCust();

	Customer findCustById(String id);

	void updateCust(Customer customer);

	void delCust(String id);

	void batchDel(String[] ids);

	List<Customer> findCustQueryOne(Customer customer);

	Page getPage(int thispage, int rowperpage);
	
}
