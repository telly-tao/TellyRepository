package day21.controller.impl;

import day21.controller.IUserController;
import day21.service.IUserService;
import day21.service.impl.UserServiceImpl;

public class UserControllerImpl implements IUserController {

	@Override
	public boolean seve(String username,String password) {
		IUserService service=new UserServiceImpl();
		boolean login=service.userLogin(username,password);
		if(login==true) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
