package com.HL.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.HL.domain.User;
import com.HL.util.JDBCUtils;

public class MysqlDao2 implements UserDao{
	
	public void addUser(User user) {
		String sql = "insert into users values (null,?,?,?,?)";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.prepareStatement(sql);
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getNickname());
			stat.setString(4, user.getEmail());
            stat.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}

	public User findUserByUNandPSW(String username, String password) {
		String sql = "select * from users where username=? and password=?";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			rs = stat.executeQuery(sql);
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}

	public User findUserByUserName(String username) {
		String sql = "select * from users where username=?";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			rs = stat.executeQuery(sql);
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				return user;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}

}
