package com.date.jum5.user.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	//메인 페이지
	@RequestMapping(value="/")
	public String mainPage() {
		return "/mainPage";
	}
		
	//서비스 안내 페이지
	@RequestMapping(value="/service")
	public String servicePage() {
		return "/user/info/service";
	}
}
