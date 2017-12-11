package com.cg.myair.service;

import com.cg.myair.bean.UserBean;
import com.cg.myair.exception.UserException;

public interface CustomerService {

	boolean validatePassword(String password, String passwd)throws UserException;

	UserBean insertDetails(UserBean bean) throws UserException;

	boolean checkAmount(String amnt) throws UserException;

}
