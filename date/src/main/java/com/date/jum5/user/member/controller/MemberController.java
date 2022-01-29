package com.date.jum5.user.member.controller;


import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.date.jum5.user.login.mapper.*;
import com.date.jum5.user.login.vo.LoginVo;
import com.date.jum5.user.member.mapper.MemberMapper;
import com.date.jum5.user.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper mapper;
	@Autowired
	private JavaMailSender mailSender;
	
	public MemberController(MemberMapper mapper, JavaMailSender mailSender) {
		this.mailSender=mailSender;
		this.mapper=mapper;
	}
	
	//회원가입 폼 요청
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signForm(Model model) {
		model.addAttribute("member", new MemberVo());
		return "user/member/signUpForm";
	}

	//회원가입 요청
		@RequestMapping(value="/signup", method=RequestMethod.POST)
		public String signCheck(@ModelAttribute("member") MemberVo member,
				Model model) {
			
			 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String signUpMsg = null;
			
			int finalCheckId = mapper.idCheck(member.getId());
			int finalCheckNick = mapper.nickNameCheck(member.getNickName());
			int finalCheckEmail = mapper.emailCheck(member.getEmail());
			
		      //회원가입 유효성 최종체크 (통과하지 못하면 다시 회원가입 폼으로감)
		      //중복 체크
		      if (finalCheckId!=0 || finalCheckNick!=0 || finalCheckEmail!=0) {
		         signUpMsg = "회원가입 정보가 올바르지 않습니다.";
		         model.addAttribute("signUpMsg", signUpMsg);
		         return "/user/member/signUpForm";
		      }   
		      //아이디가 8자미만 15자 이상일때
		      if (member.getId().length()<8 || member.getId().length()>15) {
		         signUpMsg = "회원가입 정보가 올바르지 않습니다.";
		         model.addAttribute("signUpMsg", signUpMsg);
		         return "/user/member/signUpForm";
		      } else {
		         //비밀번호 불일치 최종 체크
		         if (!member.getPassword().equals(member.getPwCheck())) {
		            signUpMsg = "회원가입 정보가 올바르지 않습니다.";
		            model.addAttribute("signUpMsg", signUpMsg);
		            return "user/member/signUpForm";
		         } else {
		            //비밀번호가 일치하면 해당 비밀번호를 암호하해서 memberVo의 password와 passwordCheck에 저장
		            String securePw = encoder.encode(member.getPassword());
		            member.setPassword(securePw);
		            member.setPwCheck(securePw);
		            
		            System.out.println(member.getPassword());
		            
		            mapper.registMember(member);
		            return "user/member/signComplete";
		         }
		      }
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

	
	//이메일 인증키 보냄
	@RequestMapping(value = "/authKeySend", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheck(@RequestParam("email") String email) throws Exception{
	    int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
	    
	    
	    String from = "abcd@company.com";//보내는 이 메일주소
	    String to = email;
	    String title = "회원가입시 필요한 인증번호 입니다.";
	    String content = "[인증번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
	    String num = "";
	    try {
	    	MimeMessage mail = mailSender.createMimeMessage();
	        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
	        
	        mailHelper.setFrom(from);
	        mailHelper.setTo(to);
	        mailHelper.setSubject(title);
	        mailHelper.setText(content, true);       
	        
	        mailSender.send(mail);
	        num = Integer.toString(serti);
	        
	    } catch(Exception e) {
	    	e.printStackTrace();
	        num = "error";
	    }
	    return num;
	}
	

	
	
	

}


