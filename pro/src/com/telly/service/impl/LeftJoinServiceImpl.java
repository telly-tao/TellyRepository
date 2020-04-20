package com.telly.service.impl;

import java.util.List;

import com.telly.dao.LeftJoinDao;
import com.telly.dao.impl.LeftJoinDaoImpl;
import com.telly.service.LeftJoinService;

public class LeftJoinServiceImpl implements LeftJoinService {

	@Override
	public List<String> leftJoin() {
		LeftJoinDao leftJoin=new LeftJoinDaoImpl();
		List<String> list = leftJoin.leftJoin();
		return list;
	}

}
