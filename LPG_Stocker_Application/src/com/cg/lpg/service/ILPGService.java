package com.cg.lpg.service;

import java.util.ArrayList;

import com.cg.lpg.bean.LPGStockBean;
import com.cg.lpg.exception.LPGException;

public interface ILPGService {
	
	ArrayList<LPGStockBean> getStockDetails(String location) throws LPGException;
	boolean updateStockDetails(int quantity,String provider)throws LPGException;
}
