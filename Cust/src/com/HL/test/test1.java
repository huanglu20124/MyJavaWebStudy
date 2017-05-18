package com.HL.test;

import org.junit.Test;

import com.HL.dao.CustDao;
import com.HL.factory.BasicFactory;
import com.HL.service.CustService;

public class test1 {
	@Test
	public static void main(String[] args) {
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
	}
}
