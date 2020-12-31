package com.kh.yseolc.emp.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.yseolc.emp.model.domain.Emp;
import com.kh.yseolc.emp.model.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
	@RequestMapping("/empsearch.action")
	public ModelAndView empSearch(HttpServletRequest request, ModelAndView mv) {
		try {
			String deptno = request.getParameter("deptno");
			String job = request.getParameter("job");
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("deptno", deptno);
			paramMap.put("job", job);
			List<Emp> empList = service.empSearch(paramMap);
			mv.addObject("empList", empList);
			mv.setViewName("empSearch");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("errorMsg", "사원 검색 중 오류가 발생하였습니다");
			mv.setViewName("error");
		}
		return mv;		
	}
	@RequestMapping(value="/empinsert.action", method= {RequestMethod.POST})
	public ModelAndView empInsert(HttpServletRequest request, ModelAndView mv) {
		try {
			String deptno = request.getParameter("deptno");
			String job = request.getParameter("job");
			String empno = request.getParameter("empno");
			String ename = request.getParameter("ename");
			
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("deptno", deptno);
			paramMap.put("job", job);
			paramMap.put("empno", empno);
			paramMap.put("ename", ename);
			int n = service.empInsert(paramMap);
			String result = "";
			if(n ==1)
				result = "사원추가 성공";
			else
				result = "사원추가 실패";
			mv.addObject("result", result);
			mv.setViewName("empSearch");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("errorMsg", "사원 검색 중 오류가 발생하였습니다");
			mv.setViewName("error");
		}
		return mv;		
	}
}
