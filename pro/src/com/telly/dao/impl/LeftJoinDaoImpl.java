package com.telly.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.telly.dao.LeftJoinDao;
import com.telly.model.Dept;
import com.telly.model.Emp;
import com.telly.util.DbUtil;
import com.telly.util.IDbUtil;

public class LeftJoinDaoImpl implements LeftJoinDao{
	@Override
	public List<String> leftJoin() {
		List<String> list=new ArrayList<String>();
		IDbUtil data=new DbUtil();
		String sql="SELECT * FROM emp e LEFT JOIN dept d ON e.deptno=d.deptno;";
		ResultSet rs=data.query(sql);
		try {
			while(rs.next()) {
				Emp emp =new Emp();
				Dept dept=new Dept();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(emp.toString().concat(dept.toString()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			data.closeQurey();
		}
		return list;
	}
}
