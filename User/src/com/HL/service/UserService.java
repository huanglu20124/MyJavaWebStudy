package com.HL.service;

import com.HL.dao.UserDao;
import com.HL.domain.User;
import com.HL.exception.MsgException;
import com.HL.factory.UserFactory;



public class UserService {
//	private XmlUserDao dao = new XmlUserDao();
//	private MySqlUserDao dao = new MySqlUserDao();
	private UserDao dao = UserFactory.getFactory().getDao();
	/**
	 * ����û�
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException{
		//1.����û����Ƿ��Ѿ�����,����Ѿ���������ʾ
		if(dao.findUserByUserName(user.getUsername())!=null){
			throw new MsgException("�û����Ѿ�����!");
		}
		//2.��������������dao�еķ�������û�
		dao.addUser(user);
	}
	
	/**
	 * ����û��������Ƿ���ȷ
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password){
		return dao.findUserByUNandPSW(username, password);
	}
	
}
