package com.kh.yseolc.cors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://domain1.com")
@Controller
public class TestCors {
	@RequestMapping(value="/aaa.do")
	public String index(Model model, HttpSession session) {
		model.addAttribute("aaa", "a 3개 테스트");
		return "home";
	}
}
