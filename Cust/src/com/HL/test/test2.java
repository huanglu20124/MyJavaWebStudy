package com.HL.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.HL.util.DaoUtils;

public class test2 {
	public static void main(String[] args) {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getDataSource());
		try {
			//ע�������м�Ķ��ű�����ģ�������
			for(int i = 0; i < 50; i++){
				   queryRunner.update(sql,
							"��·"+i+"��","��","845758437@qq.com","����,����,ƹ����",
							"13763359943","�ƽ�ͻ�","1996-11-18","������"+i);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
}
