package com.telly.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Array;
import com.telly.dao.EmpDao;
import com.telly.model.Dept;
import com.telly.model.Emp;
import com.telly.util.DbUtil;
import com.telly.util.IDbUtil;

public class EmpDaoImpl implements EmpDao {
	@Override
	public List<Emp> query(String name) {
		List<Emp> list = new ArrayList<Emp>();
		IDbUtil db = new DbUtil();
		String sql = "Select * from emp where ename like '%" + name + "%'";
		ResultSet rs = db.query(sql);
		try {
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeQurey();
		}
		
		return list;
	}

	@Override
	public int insert(Map map) {

		IDbUtil db = new DbUtil();
		int empno = (int) map.get("empno");
		String ename = (String) map.get("ename");
		String job = (String) map.get("job");
		int mgr = (int) map.get("mgr");
		String hiredate = (String) map.get("hiredate");
		double sal = (double) map.get("sal");
		double comm = (double) map.get("comm");
		int deptno = (int) map.get("deptno");
		int result = 0;
		try {
			String sql = "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)" + " values(" + empno + ",'"
					+ ename + "','" + job + "'," + mgr + ",'" + hiredate + "'," + sal + "," + comm + "," + deptno + ");";

			result = db.update(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}

	@Override
	public int update(Map map) {
		IDbUtil db=new DbUtil();
		int empno=(int)map.get("empno");
		int mgr=(int)map.get("mgr");
		String sql="update emp set mgr="+mgr+" where empno="+empno+";";
		return db.update(sql);
	}

	@Override
	public int delete(int id) {
		IDbUtil db =new DbUtil();
		int empno=id;
		String sql="delete from emp where empno="+empno+"";
		return db.update(sql);
	}

}
