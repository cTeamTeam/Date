package org.project.date.user.controller.member;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.project.date.user.mapper.member.MemberMapper;
import org.project.date.user.vo.member.MemberVo;
import org.project.date.user.vo.member.ProfileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper mapper;
	
	public MemberController(MemberMapper mapper) {
		this.mapper=mapper;
	}
	
	//회원가입 폼 요청
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signForm(Model model) {
		model.addAttribute("member", new MemberVo());
		return "signUpForm";
	}
	
	//회원가입 요청
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signCheck(@ModelAttribute("member") @Valid MemberVo member) {
		
		int finalCheckId = mapper.idCheck(member.getId());
		int finalCheckNick = mapper.nickNameCheck(member.getNickName());
		int finalCheckEmail = mapper.emailCheck(member.getEmail());
		
		if (finalCheckId!=0 || finalCheckNick!=0 || finalCheckEmail!=0) {
			return "signUpForm";
		} else {
			if (!member.getPassword().equals(member.getPwCheck())) {
				return "signUpForm";
			} else {
				mapper.test(member);
			}
		}
		return "signComplete";
	}

	
	//중복 아이디 체크
	@ResponseBody
	@RequestMapping(value="/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestParam("id") String id) throws RuntimeException {
		
		int idCheckResult = mapper.idCheck(id);
		return idCheckResult;
	}
	
	//중복 닉네임 체크
	@ResponseBody
	@RequestMapping(value="/nickNameCheck", method=RequestMethod.POST)
	public int nickNameCheck(@RequestParam("nickName") String nickName) throws Exception {

		int nickCheckResult = mapper.nickNameCheck(nickName);
		return nickCheckResult;
	}

	//중복 이메일 체크
	@ResponseBody
	@RequestMapping(value="/emailCheck", method=RequestMethod.POST)
	public int emailCheck(@RequestParam("email") String email) throws Exception {
		
		int emailCheckResult = mapper.emailCheck(email);
		return emailCheckResult;
	}
	
	
	
}
