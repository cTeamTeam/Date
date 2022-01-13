package org.project.date.user.controller.member;


import javax.validation.Valid;

import org.project.date.user.mapper.member.MemberMapper;
import org.project.date.user.vo.member.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String signCheck(@ModelAttribute("member") @Valid MemberVo member,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "signUpForm";
		}
		
		System.out.println("아이디 : " +member.getId());
		System.out.println("비밀번호 : "+member.getPassword());
		System.out.println("비번확인 : "+member.getPwCheck());
		System.out.println("이름 : "+member.getName());
		System.out.println("생년월일 : "+member.getBirth());
		System.out.println("닉네임 : "+member.getNickName());
		System.out.println("성별 : "+member.getGender());
		System.out.println("전화번호 :"+member.getPhoneNum());
		mapper.test(member);
		return null;
	}
	
	@RequestMapping(value="/idCheck/{id}")
	public String idChcek(@PathVariable String id,
			Model model) {
			
		String msg=null;
		int idCheck = mapper.idCheck(id);
		model.addAttribute("idCheck", idCheck);
		if (idCheck!=1) {
			msg="사용 가능한 아이디입니다";
		} else {
			msg="중복된 아이디 입니다";
		}
		model.addAttribute("checkMessage", msg);
		
		return "idCheck";
	}
	
	@RequestMapping(value="/nickNameCheck/{nickName}")
	public String nickNameCheck(@PathVariable String nickName) {
		System.out.println(nickName);
		return "nickNameCheck";
	}
	
	
	
}
