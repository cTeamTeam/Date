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
		
		/*System.out.println("아이디 : " +member.getId());
		System.out.println("비밀번호 : "+member.getPassword());
		System.out.println("비번확인 : "+member.getPwCheck());
		System.out.println("이름 : "+member.getName());
		System.out.println("생년월일 : "+member.getBirth());
		System.out.println("닉네임 : "+member.getNickName());
		System.out.println("성별 : "+member.getGender());
		System.out.println("전화번호 :"+member.getPhoneNum());*/
		
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
			msg=id +"은(는) 사용 가능한 아이디입니다";
		} else {
			msg=id +"은(는) 중복된 아이디 입니다";
		}
		model.addAttribute("checkMessage", msg);
		
		return "idCheck";
	}
	
	@RequestMapping(value="/nickNameCheck/{nickName}")
	public String nickNameCheck(@PathVariable String nickName,
			Model model) {
		
		String msg=null;
		int nickNameCheck = mapper.nickNameCheck(nickName);
		model.addAttribute("nickNameCheck", nickNameCheck);
		if (nickNameCheck!=0) {
			msg= nickName +"은(는) 이미 사용중인 닉네임 입니다";
		} else {
			msg=nickName +"은(는) 사용 가능한 닉네임 입니다";
		}
		model.addAttribute("msg", msg);
		
		return "nickNameCheck";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profile(@ModelAttribute("profile") ProfileVo profile) {
		return "profile";
	}
	
	//프로필 입력이 완료되면 창을 닫으면서 데이터를 보냄
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public void profileSuccess(@ModelAttribute("profile") ProfileVo profile,
			HttpServletResponse response) throws IOException {
	
		PrintWriter out = response.getWriter();
		out.println("<script>window.close('profile.jsp')");
		out.println("</script>");
		
		System.out.println("키 : "+profile.getHeight());
		System.out.println("몸무게 : "+profile.getWeight());
		System.out.println("성격 : " +profile.getCharacter());
		System.out.println("취미 : "+profile.getHobby());
		System.out.println("혈액형 : "+profile.getBloodType());
		System.out.println("직업 : "+profile.getJob());
		System.out.println("연봉 : " +profile.getSalary());
		System.out.println("주소 : "+profile.getAddress());
		System.out.println("주소 : "+profile.getImageFile());
		
		System.out.println("hi");
	}
	
	
}
