package com.HL.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.HL.dao.CustDao;
import com.HL.dao.CustDaoImpl;
import com.HL.domain.Customer;
import com.HL.domain.Page;
import com.HL.factory.BasicFactory;
import com.HL.util.DaoUtils;

public class CustServiceImpl implements CustService {
//	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	CustDaoImpl dao= new CustDaoImpl(); 
	@Override
	public void addCust(Customer customer) {
		// TODO Auto-generated method stub
		//1.检查用户名是否已经存在
		if(dao.isFindUserByName(customer.getName())!=null){
			throw new RuntimeException("用户名已经存在!!");
		}
		//2.调用dao中的方法增加用户
		dao.addCust(customer);
	}
	
	@Override
	public List<Customer> getAlllCust() {
		// TODO Auto-generated method stub
		return dao.getAllCust();
	}

	@Override
	public Customer findCustById(String id) {
		// TODO Auto-generated method stub
		return dao.findCustById(id);
	}

	@Override
	public void updateCust(Customer customer) {
		// TODO Auto-generated method stub
		dao.updateCust(customer);
	}

	@Override
	public void delCust(String id) {
		// TODO Auto-generated method stub
		dao.delCust(id);
	}

	@Override
	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
		Connection connection = DaoUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			for(String id : ids){
				//dbUtil的回滚需要传connection进去
				dao.delCustForBatch(connection,id);
			}
			DbUtils.commitAndCloseQuietly(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			DbUtils.rollbackAndCloseQuietly(connection);
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Customer> findCustQueryOne(Customer customer) {
		// TODO Auto-generated method stub
		return dao.findCustQueryOne(customer);
	}

	@Override
	public Page getPage(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<Customer> list = (List<Customer>) dao.getPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}
	
	
	

}
