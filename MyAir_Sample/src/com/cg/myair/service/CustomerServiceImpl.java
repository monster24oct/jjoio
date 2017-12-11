package com.cg.myair.service;

import com.cg.myair.bean.UserBean;
import com.cg.myair.dao.CustomerDao;
import com.cg.myair.dao.CustomerDaoImpl;
import com.cg.myair.exception.UserException;

public class CustomerServiceImpl implements CustomerService {
 
	CustomerDao dao;
	 public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
		 dao=new CustomerDaoImpl();
	}
	@Override
	public boolean validatePassword(String password, String passwd) throws UserException{
		// TODO Auto-generated method stub
		boolean flag=false;
		if(password.equals(passwd))
		{
			flag=true;
			
		}
		return flag;
		
	}
	@Override
	public UserBean insertDetails(UserBean bean) throws UserException {
		// TODO Auto-generated method stub
		return dao.insertDetails(bean);
	}
	@Override
	public boolean checkAmount(String amnt) throws UserException{
		// TODO Auto-generated method stub
		boolean flag=false;
		int amount=Integer.parseInt(amnt);
		if(amount>0 && amount<750)
			flag=true;
		return flag;
	}

}
