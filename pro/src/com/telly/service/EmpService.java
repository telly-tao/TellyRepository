package com.telly.service;

import java.util.List;
import java.util.Map;

import com.telly.model.Emp;;

public interface EmpService {
	public List<Emp> query(String name);
	
	public int insert(Map map);
	
	public int update(Map map);
	
	public int delete(int id);
}
