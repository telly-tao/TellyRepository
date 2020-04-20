package com.telly.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Data;
import com.telly.model.Emp;
import com.telly.service.EmpService;
import com.telly.service.impl.EmpServiceImpl;

public class EmpControllerImpl {
	@Test
	public void test() {
		String name = "a";
		EmpService es = new EmpServiceImpl();
		List<Emp> list = es.query(name);
		for (Emp emp : list) {
			System.out.println(emp.toString());
		}
	}

	@Test
	public void testInsert() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("empno", new Integer(1));
			map.put("ename", "张爽");
			map.put("job", "C#");
			map.put("mgr", 2221);
			map.put("hiredate", "2020-04-16");
			map.put("sal", 5000.0);
			map.put("comm", 200.0);
			map.put("deptno", 10);
			EmpService emp = new EmpServiceImpl();
			int result = emp.insert(map);
			if (result != 0) {
				System.out.println("插入成功！");
			}
			else {
				System.out.println("插入失败！");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdate() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empno", 1);
		map.put("mgr", 7902);
		EmpService emp=new EmpServiceImpl();
		int result =emp.update(map);
		if (result != 0) {
			System.out.println("修改成功！");
		}
		else {
			System.out.println("修改失败！");
		}
		
	}
	@Test
	public void testDalete() {
		EmpService emp=new EmpServiceImpl();
		int empno=1;
		int result=emp.delete(empno);
		if (result != 0) {
			System.out.println("删除成功！");
		}
		else {
			System.out.println("删除失败！");
		}
	}
}
