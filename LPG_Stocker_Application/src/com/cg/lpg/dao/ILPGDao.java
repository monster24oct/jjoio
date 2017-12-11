package com.cg.lpg.dao;

import java.util.ArrayList;

import com.cg.lpg.bean.LPGStockBean;
import com.cg.lpg.exception.LPGException;

public interface ILPGDao {
	
		ArrayList<LPGStockBean> getStockDetails(String location) throws LPGException;
		boolean updateStockDetails(int quantity,String provider)throws LPGException;
}
