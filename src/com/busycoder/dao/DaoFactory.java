package com.busycoder.dao;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
	private Map<String, Object> daoMap = new HashMap<String, Object>();
	private volatile static DaoFactory daoFactory;
	
	//private construct method
	private DaoFactory(){
		try{
			UserDao ud = new UserDao();
			daoMap.put("userDao", ud);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//singleton
	public static DaoFactory getInstance(){
		if(daoFactory == null){
			synchronized (DaoFactory.class) {  
		        if (daoFactory == null) {  
		        	daoFactory = new DaoFactory(); 
		        } 
			}
		}
		return daoFactory;
	}
	
	public Object getDao(String id){
		return daoMap.get(id);
	}
}