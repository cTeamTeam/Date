package org.project.date.user.controller.mainpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {
	//메인 페이지
		@RequestMapping(value="/")
		public String mainPage() {
			return "/member/mainPage";
		}
		
		//서비스 안내 페이지
		@RequestMapping(value="/service")
		public String servicePage() {
			return "/member/service";
		}
}
