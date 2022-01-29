package com.date.jum5.user.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.date.jum5.user.mypage.mapper.MyPageMapper;

@Controller
public class MyPageController {
	
	@Autowired
	MyPageMapper mapper;
	
	@RequestMapping(value="/myPage/{id}",method=RequestMethod.GET)
	public String myPage(Model model,@PathVariable String id) {
		model.addAttribute("myPageList", mapper.list(id));
		return "member/myPage";
	}
	

}
