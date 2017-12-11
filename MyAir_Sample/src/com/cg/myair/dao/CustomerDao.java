package com.cg.myair.dao;

import com.cg.myair.bean.UserBean;
import com.cg.myair.exception.UserException;

public interface CustomerDao {

	UserBean insertDetails(UserBean bean) throws UserException;

}
