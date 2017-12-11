package com.cg.lpg.service;

import java.util.ArrayList;

import com.cg.lpg.bean.LPGStockBean;
import com.cg.lpg.dao.ILPGDao;
import com.cg.lpg.dao.LPGDaoImpl;
import com.cg.lpg.exception.LPGException;

public class LPGServiceImpl implements ILPGService{
	static ILPGDao lpgDao = new LPGDaoImpl();
	@Override
	public ArrayList<LPGStockBean> getStockDetails(String location)
			throws LPGException {
		
		return lpgDao.getStockDetails(location);
	}

	@Override
	public boolean updateStockDetails(int quantity, String provider)
			throws LPGException {
		return lpgDao.updateStockDetails(quantity, provider);
	}

}
