package com.telly.dao;

import java.util.List;
import java.util.Map;

import com.telly.model.Emp;

public interface EmpDao {
	public List<Emp> query(String name);
	
	public int insert(Map map);
	
	public int update(Map map);
	
	public int delete(int id);
}
