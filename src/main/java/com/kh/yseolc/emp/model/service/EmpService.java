package com.kh.yseolc.emp.model.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yseolc.emp.model.dao.EmpDao;
import com.kh.yseolc.emp.model.domain.Emp;

@Service
public class EmpService {
	private static final Logger logger = LoggerFactory.getLogger(EmpService.class);
	
	@Autowired
	private EmpDao dao;
	
	public List<Emp> empSearch(HashMap<String,String> paramMap){
		return dao.empSearch(paramMap);
	}
	
	public int empInsert(HashMap<String,String> paramMap){
		logger.info("empInsert");
		return dao.empInsert(paramMap);
	}
	
}
