package day21.service.impl;

import day21.dao.IUserDao;
import day21.dao.impl.UserDaoImpl;
import day21.service.IUserService;

public class UserServiceImpl implements IUserService {
	@Override
	public boolean userLogin(String username,String password) {
		IUserDao dao=new UserDaoImpl();
		if(username.equals(dao.getUsername())&&password.equals(dao.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}
