package com.telly.controller;

import java.util.List;

import org.junit.Test;

import com.telly.model.Emp;
import com.telly.service.EmpService;
import com.telly.service.LeftJoinService;
import com.telly.service.impl.EmpServiceImpl;
import com.telly.service.impl.LeftJoinServiceImpl;

public class TestController {

	@Test
	public void emp() {
		String name="a";
		EmpService es=new EmpServiceImpl();
		List<Emp> list=es.query(name);
		for(Emp emp:list) {
			System.out.println(emp.toString());
		}
	}
	@Test
	public void leftJoin() {
		LeftJoinService lj=new LeftJoinServiceImpl() ;
		List<String> lf= lj.leftJoin();
		for(String list:lf) {
			System.out.println(list);
		}
	}
}
