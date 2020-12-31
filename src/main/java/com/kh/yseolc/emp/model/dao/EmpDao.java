package com.kh.yseolc.emp.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yseolc.emp.model.domain.Emp;


@Repository
public class EmpDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Emp> empSearch(HashMap<String,String> paramMap){
		return sqlSession.selectList("searchList", paramMap);
	}
	
	public int empInsert(HashMap<String, String> emp) {
		return sqlSession.insert("insertEmp", emp);
	}
}
