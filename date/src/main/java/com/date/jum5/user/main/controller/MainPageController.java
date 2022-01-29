package com.date.jum5.user.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {
	
	//메인 페이지
		@RequestMapping(value="/")
		public String mainPage() {
			return "user/member/mainPage";
		}
		
		@RequestMapping(value="/mainPage")
		public String gomainPage() {
			return "user/member/mainPage";
		}
		
		//서비스 안내 페이지
		@RequestMapping(value="/service")
		public String servicePage() {
			return "user/member/service";
		}
}
