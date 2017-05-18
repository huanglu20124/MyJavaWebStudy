package com.HL.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.HL.domain.Customer;
import com.HL.domain.Page;
import com.HL.util.DaoUtils;

public class CustDaoImpl implements CustDao{

	@Override
	public Object isFindUserByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select*from customer where name=?";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			return queryRunner.query(sql, new BeanHandler<Customer>(Customer.class),name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addCust(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
		   queryRunner.update(sql,
					customer.getName(),customer.getGender(),customer.getEmail(),customer.getPreference(),
					customer.getCellphone(),customer.getCus_type(),customer.getBirthday(),customer.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}

	@Override
	public List<Customer> getAllCust() {
		// TODO Auto-generated method stub
		String sql = "select*from customer";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			return queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Customer findCustById(String id) {
		// TODO Auto-generated method stub
		String sql = "select*from customer where id=?";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			return (Customer) queryRunner.query(sql, new BeanHandler<Customer>(Customer.class),id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCust(Customer customer) {
		// TODO Auto-generated method stub
		String sql="update customer set gender=?,email=?,preference=?," +
				"birthday=?,cellphone=?,cus_type=?,description=? where id=?";
		System.out.println(customer.getId());
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			queryRunner.update(sql, customer.getGender(),customer.getEmail(),customer.getPreference(),
					customer.getBirthday(),customer.getCellphone(),customer.getCus_type(),customer.getDescription(),customer.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delCust(String id) {
		// TODO Auto-generated method stub
		String sql="delete from customer where id=?";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			queryRunner.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delCustForBatch(Connection connection,String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from customer where id=?";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		queryRunner.update(connection,sql,id);
	}

	@Override
	public List<Customer> findCustQueryOne(Customer cust) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(cust.getName()!=null && !"".equals(cust.getName())){
			sql += " and name like ? ";
			list.add("%"+cust.getName()+"%");
		}
		if(cust.getGender()!=null && !"".equals(cust.getGender())){
			sql += " and gender = ? ";
			list.add(cust.getGender());
		}
		if(cust.getCus_type()!=null && !"".equals(cust.getCus_type())){
			sql += " and cus_type = ? ";
			list.add(cust.getCus_type());
		}
		
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
			}else{
				return runner.query(sql, new BeanListHandler<Customer>(Customer.class),list.toArray());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Customer> getPage(int from, int count) {
		// TODO Auto-generated method stub
		String sql = "select * from customer limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return  runner.query(sql, new BeanListHandler<Customer>(Customer.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from customer";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			return  ((Long)queryRunner.query(sql, new ScalarHandler())).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}



	


}
