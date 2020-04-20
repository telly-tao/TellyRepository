package com.telly.service.impl;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.telly.dao.EmpDao;
import com.telly.dao.impl.EmpDaoImpl;
import com.telly.model.Emp;
import com.telly.service.EmpService;

public class EmpServiceImpl implements EmpService{
	@Override
	public List<Emp> query(String name) {
		EmpDao emp=new EmpDaoImpl();
		return emp.query(name);
	}

	@Override
	public int insert(Map map) {
		EmpDao emp=new EmpDaoImpl();
		return emp.insert(map);
	}

	@Override
	public int update(Map map) {
		EmpDao emp=new EmpDaoImpl();
		return emp.update(map);
	}

	@Override
	public int delete(int id) {
		EmpDao emp=new EmpDaoImpl();
		return emp.delete(id);
	}
}
