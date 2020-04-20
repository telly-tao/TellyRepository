package com.telly.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.telly.util.DbUtil;

public class TestWork {

	@Test
	public void insert() {
		DbUtil db = new DbUtil();
		String sql1 = "insert into dept(deptno,dname,loc) values(52,'������','����');";
		String sql2 = "INSERT INTO `emp` VALUES ('6666', 'MI', 'c', '1', '1988-01-01', '2000.00', '1.00', null);";
		// ��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
		int rs1 = db.update(sql1);
		int rs2 = db.update(sql2);
		System.out.println("����� " + rs1);
		System.out.println("����� " + rs2);
	}
	@Test
	public void update() {
		DbUtil db = new DbUtil(); 
		String sql = "update emp set job ='Java'  where empno=6666";
		// ��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
		int rs = db.update(sql);
		System.out.println("����� " + rs);
	}
	@Test
	public void delete() {
		DbUtil db = new DbUtil();
		String sql = "delete from emp where empno=6666";
		// ��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
		int rs = db.update(sql);
		System.out.println("����� " + rs);
	}
	
	@Test
	public void leftjoin() {
		DbUtil db = new DbUtil();
		String sql = "select e.*,d.dname from emp AS e left join dept d on e.deptno=d.deptno;";
		// ��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
		ResultSet rs = db.query(sql);
		try {
			while (rs.next()) {
				String ename = rs.getString("ename");
				String dname = rs.getString("dname");
				System.out.println(ename + "  ," + dname);
			}
			db.closeQurey();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
