package day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import day21.controller.IUserController;
import day21.controller.impl.UserControllerImpl;

public class User {

	public static void main(String[] args) {
		try {
			IUserController c = new UserControllerImpl();
			BufferedReader readln = new BufferedReader(new InputStreamReader(System.in));
			boolean login = true;
			while (login) {
				System.out.println("请输入用户名：");
				String name = readln.readLine();
				System.out.println("请输入密码：");
				String pwd = readln.readLine();

				login = c.seve(name, pwd);
				if (login == true) {
					System.out.println("登录成功！");
					login=false;
					break;
				} else {
					System.out.println("登录失败！请重新登录。");
					login=true;
				}
			}
		} catch (Exception e) {
			System.out.println("input error!");
		}
	}

}
