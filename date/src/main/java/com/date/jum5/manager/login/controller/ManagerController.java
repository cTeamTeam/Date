package com.date.jum5.manager.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.date.jum5.manager.login.mapper.ManagerLoginService;
import com.date.jum5.manager.login.vo.ManagerLoginVo;

@Controller
public class ManagerController {

    @Autowired
    private ManagerLoginService ManagerLoginService;
      
    //로그인 화면
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String login_form() {
		return "/admin/login/loginForm";
	}

	//로그인
	@RequestMapping(value="/managerlogin", method=RequestMethod.POST)
	public String login(@ModelAttribute ManagerLoginVo managerLoginVo, HttpSession session, Model model) throws Exception{
		
		String pw = ManagerLoginService.checkId(managerLoginVo.getId());
		
		int idCount = ManagerLoginService.idExist(managerLoginVo.getId());
		
		if (idCount==0) {
			model.addAttribute("msg", 1);
			return "/admin/login/loginFalse";
		} else {
			if (!pw.equals(managerLoginVo.getPw())) {
				model.addAttribute("msg", 2);
				return "/admin/login/loginFalse";
			} else {
				session.setAttribute("adminId", managerLoginVo.getId());
				return "adminMain";
			}
		}
		
		
	}
	
	@RequestMapping(value = "/admin/logout" , method = RequestMethod.GET)
	public String logOutPage(HttpServletRequest request) throws Exception{
		
		 HttpSession session = request.getSession();
		 
		 session.invalidate();
		
		return "admin/login/logout";
	}
	
}
