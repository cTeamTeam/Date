package org.project.date.user.controller.member;


import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.project.date.user.mapper.member.MemberMapper;
import org.project.date.user.vo.member.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
		return "signUpForm";
	}
	
	//회원가입 요청
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signCheck(@ModelAttribute("member") @Valid MemberVo member,
			Model model,
			BindingResult bindingResult) {

		String signUpMsg = null;
		//마지막으로 null값이 있는지 체크
		/*if (bindingResult.hasErrors()) {
			signUpMsg = "회원가입 정보가 올바르지 않습니다.";
			model.addAttribute("signUpMsg", signUpMsg);
			return "signUpForm";
		}*/
		
		int finalCheckId = mapper.idCheck(member.getId());
		int finalCheckNick = mapper.nickNameCheck(member.getNickName());
		int finalCheckEmail = mapper.emailCheck(member.getEmail());
		
		//중복 확인 최종 체크
		if (finalCheckId!=0 || finalCheckNick!=0 || finalCheckEmail!=0) {
			signUpMsg = "회원가입 정보가 올바르지 않습니다.";
			model.addAttribute("signUpMsg", signUpMsg);
			return "signUpForm";
		} else {
			//비밀번호 불일치 최종 체크
			if (!member.getPassword().equals(member.getPwCheck())) {
				signUpMsg = "회원가입 정보가 올바르지 않습니다.";
				model.addAttribute("signUpMsg", signUpMsg);
				return "signUpForm";
			} else {
				mapper.registMember(member);
				return "signComplete";
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
	
	/*
	//마이페이지
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String myPage(Model model, @RequestParam("id") String id) {
		model.addAttribute("myPage",mapper.myPage(id));
		return "myPage";
	}
	*/
	
	//마이페이지 테스트용 - 아직 로긍니 값 받지 못함 --> 세션?인가 써야할듯;
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("myPageList",mapper.list());
		return "myPage";
	}
	
	
	//회원 탈퇴 구현 테스트
	//id로 할지 num으로 할지 고민중;; 아마 마이페이지 값 따라갈듯 세션 스테이트를 1로 변경
	@RequestMapping(value="/withdraw", method = RequestMethod.GET)
	public String withdraw(Model model) {
		model.addAttribute("withdraw", mapper.withdraw());
		return "withdraw";
	}
	
	
	/*
	// 비밀번호 변경
	@RequestMapping(value="/editPw", method=RequestMethod.POST )
	public String editPw(Model model, int pwd,BindingResult result,SessionStatus sessionStatus)
	*/
	
	//메인 페이지
	@RequestMapping(value="/mainPage", method=RequestMethod.GET)
	public String mainPage() {
		return "mainPage";
	}
	
	//서비스 안내 페이지
	@RequestMapping(value="/service", method=RequestMethod.GET)
	public String servicePage() {
		return "service";
	}
	
}
