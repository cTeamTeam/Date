package org.project.date.user.controller.mypage;

import org.project.date.user.mapper.mypage.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyPageController {
	
	@Autowired
	MyPageMapper mapper;
	
	

}
