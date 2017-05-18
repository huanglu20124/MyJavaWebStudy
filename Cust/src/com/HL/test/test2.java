package com.HL.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.HL.util.DaoUtils;

public class test2 {
	public static void main(String[] args) {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			//注意球类中间的逗号别打中文，后面会跪！
			for(int i = 0; i < 50; i++){
				   queryRunner.update(sql,
							"黄路"+i+"号","男","845758437@qq.com","篮球,足球,乒乓球",
							"13763359943","黄金客户","1996-11-18","爆肝佬"+i);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
}
