package com.telly.mysql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.telly.util.DbUtil;

public class TestDb {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_test?useUnicode=true&characterEncoding=UTF8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	@Test
	public void ttt() {
		
		File f =new File("C:\\large.txt");
		
	}
	@Test
	public void query() {
		DbUtil db = new DbUtil();
		String sql = "select * from dept";
		// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
		ResultSet rs = db.query(sql);
		try {
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + dname + loc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 预编译Statement
	 */
	@Test
	public void Query() {
		// 连接数据库时，需提供数据库的地址、用户名、密码
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			// 加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			// 创建连接对象
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// 编写查询语句
			String sql = "select * from dept where deptno=? and dname=?";
			// 创建适配器
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, 10);
			psmt.setString(2, "ACCOUNTING");
			// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + dname + loc);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		} finally {
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Test
	public void count() {
		DbUtil db = new DbUtil();
		String sql = "select count(*) AS num from dept";
		// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
		ResultSet rs = db.query(sql);
		try {
			if (rs.next()) {
				int num = rs.getInt("num");

				System.out.println("数量：" + num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void insert() {
		DbUtil db = new DbUtil();
		String sql1 = "insert into dept(deptno,dname,loc) values(51,'技术部','长春');";
		String sql2 = "INSERT INTO `emp` VALUES ('6666', 'MI', 'c', '1', '1988-01-01', '2000.00', '1.00', null);";
		// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
		int rs1 = db.update(sql1);
		int rs2 = db.update(sql2);
		System.out.println("结果： " + rs1);
		System.out.println("结果： " + rs2);
	}
	@Test
	public void update() {
		DbUtil db = new DbUtil(); 
		String sql = "update emp set job ='Java'  where empno=6666";
		// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
		int rs = db.update(sql);
		System.out.println("结果： " + rs);
	}
	@Test
	public void delete() {
		DbUtil db = new DbUtil();
		String sql = "delete from emp where empno=51";
		// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
		int rs = db.update(sql);
		System.out.println("结果： " + rs);
	}
	
	@Test
	public void leftjoin() {
		DbUtil db = new DbUtil();
		String sql = "select e.*,d.dname from emp AS e left join dept d on e.deptno=d.deptno";
		// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
		ResultSet rs = db.query(sql);
		try {
			while (rs.next()) {
				String ename = rs.getString("ename");
				String dname = rs.getString("dname");
				System.out.println(ename + "  ," + dname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
