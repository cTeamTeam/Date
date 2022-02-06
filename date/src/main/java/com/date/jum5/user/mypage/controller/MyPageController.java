package com.date.jum5.user.mypage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.date.jum5.user.login.vo.LoginVo;
import com.date.jum5.user.mypage.mapper.MyPageMapper;
import com.date.jum5.user.mypage.vo.ProfileVo;
import com.date.jum5.user.login.mapper.LoginService;

@Controller
@SessionAttributes("loginVo")
public class MyPageController {
	
	@Autowired
	MyPageMapper mapper;
	
	@Autowired
	LoginService loginService;
	//마이페이지
	@RequestMapping(value="/myPage/{id}",method=RequestMethod.GET)
	public String myPage(Model model,@PathVariable String id) {
		model.addAttribute("loginVo", mapper.mypageList(id));
		// 프로필 리스트 -> 없으면 프로필 등록 버튼? 클릭할 수 있게
		model.addAttribute("profileVo", mapper.profileList(id));
		return "user/mypage/myPage";
	}
	
	//프로필 등록 Form
	@RequestMapping(value="/insertProfile/{id}", method=RequestMethod.GET)
	public String insertProfile(Model model,@PathVariable String id) {
		model.addAttribute("profileVo", new ProfileVo());
		return "user/mypage/insertProfile";
	}
	
	//프로필 등록
	@RequestMapping(value="/insertProfile/{id}", method=RequestMethod.POST)
	public String insertProfile(ProfileVo profileVo, BindingResult bindingResult,@PathVariable String id)  {
		if(bindingResult.hasErrors()){
			System.out.println(profileVo.getCharacter());
			return "user/mypage/insertProfile";
		}else {
			mapper.write(profileVo);
		
			return "user/mypage/insertProfileSuccess";
		}
	}
	
	//회원 정보 변경
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(Model model, @PathVariable String id,LoginVo loginVo) {
		model.addAttribute("loginVo",loginVo);
		return "user/mypage/edit";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public String edit(Model model, @PathVariable String id, @ModelAttribute LoginVo loginVo, BindingResult bindingResult, SessionStatus sessionStatus) {
	
		if(bindingResult.hasErrors()) {
			return "/user/mypage/edit";
		}else {
				mapper.edit(loginVo);
				return "user/mypage/editSuccess";
			}
		
		//model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
		
		//id 값을 받아야됨
		
	}
	
	
	// 회원 탈퇴
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable String id) {
		model.addAttribute("id", id);
		return "user/mypage/delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(String id, String pwd, Model model) {
		
		LoginVo loginVo= new LoginVo();
		loginVo.setId(id);
		loginVo.setPassword(pwd);
		
		String page = "";
		
		//해당 입력된 아이디로 암호화된 비밀번호 가져오기
		String pwEncryption = loginService.pwTranslator(loginVo.getId());
		System.out.println("암호화된 비밀번호 : " +pwEncryption);
		
		//loginVo.setPassword(pwEncryption);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//암호화된 비밀번호랑 입력한 비밀번호가 같은지 확인
		boolean check = encoder.matches(loginVo.getPassword(), pwEncryption);
		//loginVo.setPassword(pwEncryption);
		System.out.println(check);
		
		if(!check) {
			return "user/mypage/myPage";
		}
		else {
			mapper.delete(loginVo);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "user/mypage/deleteSuccess";
		}
	}
	
	//프로필 수정
	//회원 정보 변경
	@RequestMapping(value="/editProfile/{id}", method=RequestMethod.GET)
	public String editProfile(Model model, @PathVariable String id,ProfileVo profileVo) {
		model.addAttribute("profileVo",profileVo);
		return "user/mypage/editProfile";
	}
	
	@RequestMapping(value="/editProfile/{id}", method = RequestMethod.POST)
	public String editProfile(Model model, @PathVariable String id, @ModelAttribute ProfileVo profileVo, BindingResult bindingResult, SessionStatus sessionStatus) {
	
		if(bindingResult.hasErrors()) {
			return "/user/mypage/editProfile";
		}else {
				mapper.editProfile(profileVo);
				return "user/mypage/editProfileSuccess";
			}
		
		//model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
		
		//id 값을 받아야됨
		
	}

}
