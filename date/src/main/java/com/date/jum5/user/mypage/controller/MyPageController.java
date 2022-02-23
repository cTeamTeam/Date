package com.date.jum5.user.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.date.jum5.user.login.mapper.LoginService;
import com.date.jum5.user.login.vo.LoginVo;
import com.date.jum5.user.metch.mapper.MetchMapper;
import com.date.jum5.user.mypage.mapper.MyPageMapper;
import com.date.jum5.user.mypage.vo.ProfileVo;

@Controller
public class MyPageController {
	
	@Autowired
	MyPageMapper mapper;
	@Autowired
	LoginService loginService;
	@Autowired
	MetchMapper metchMapper;
	
	//마이페이지
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String myPage(Model model, HttpServletRequest request) {
		
		//현재 로그인된 세션 값 가져오기 (닉네임)
//		String id = (String) session.getAttribute("loginVo");
		HttpSession session = request.getSession();
		String userId =(String)session.getAttribute("loginVo");
		model.addAttribute("test", mapper.mypageList(userId));
		// 프로필 리스트 -> 없으면 프로필 등록 버튼? 클릭할 수 있게
		model.addAttribute("date", metchMapper.beRequested(userId));
		model.addAttribute("profileVo", mapper.profileList(userId));
		return "user/mypage/myPage";
	}
	
	//프로필 등록 Form
	@RequestMapping(value="/insertProfile", method=RequestMethod.GET)
	public String insertProfile(Model model, HttpSession session) {
		
		model.addAttribute("profileVo", new ProfileVo());
		return "user/mypage/insertProfile";
	}
	
	//프로필 등록
	@RequestMapping(value="/insertProfile", method=RequestMethod.POST)
	public String insertProfile(ProfileVo profileVo, BindingResult bindingResult,
			HttpSession session) throws IllegalStateException, IOException  {
		
		String id2 = (String) session.getAttribute("loginVo");
		System.out.println("나이 : "+profileVo.getAge());
		
		if(bindingResult.hasErrors()){
			System.out.println("에러");
			return "user/mypage/insertProfile";
		}else {
			String fileName=null;
			MultipartFile uploadFile = profileVo.getUploadFile();
			if(!uploadFile.isEmpty()) {
				String originalFileName = uploadFile.getOriginalFilename();
				System.out.println("오리지날 이름 : "+originalFileName);
				UUID uuid =UUID.randomUUID();
				fileName=uuid+"."+"jpg";
				uploadFile.transferTo(new File("C:\\Users\\ehdrm\\git\\date2\\date\\date\\src\\main\\webapp\\resources\\images\\"+fileName));
			
			}
			profileVo.setImageFile(fileName);
			profileVo.setNickname(id2);
			mapper.write(profileVo);
					
			return "user/mypage/insertProfileSuccess";
		}
	}
	
	//회원 정보 변경
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(Model model, HttpSession session) {
		model.addAttribute("editMember", new LoginVo());
		
		LoginVo edit = loginService.editMember((String) session.getAttribute("loginVo"));
		
		model.addAttribute("editMember", edit);
		
		return "user/mypage/edit";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String edit(Model model,  @ModelAttribute LoginVo loginVo,
			BindingResult bindingResult, SessionStatus sessionStatus,
			HttpSession session) {
	
		if(bindingResult.hasErrors()) {
			return "/user/mypage/edit";
		}else {
			String id = mapper.editId((String) session.getAttribute("loginVo"));
			System.out.println(id);
			loginVo.setId(id);
			mapper.edit(loginVo);
			return "user/mypage/editSuccess";
		}
		
		//model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
		
		//id 값을 받아야됨
		
	}
	
	
	// 회원 탈퇴
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Model model,
			HttpSession session) {
		
		model.addAttribute("id", (String) session.getAttribute("loginVo"));
		return "user/mypage/delete";
	}
	
	//회원 탈퇴
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(String pwd, Model model,
			HttpSession session) {
		
		System.out.println((String) session.getAttribute("loginVo"));
		System.out.println(pwd);
		
		LoginVo loginVo= new LoginVo();
		loginVo.setNickname((String) session.getAttribute("loginVo"));
		loginVo.setPassword(pwd);
		
		String page = "";
		
		//해당 입력된 아이디로 암호화된 비밀번호 가져오기
		String pwEncryption = loginService.pwTranslatorDelete(loginVo.getNickname());
		
		//loginVo.setPassword(pwEncryption);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//암호화된 비밀번호랑 입력한 비밀번호가 같은지 확인
		boolean check = encoder.matches(loginVo.getPassword(), pwEncryption);
		//loginVo.setPassword(pwEncryption);
		
		if(!check) {
			model.addAttribute("msg", 1);
			return "user/mypage/deleteSuccess";
		}
		else {
			mapper.delete(loginVo);
			session.removeAttribute("loginVo");
			model.addAttribute("msg", 2);
			return "user/mypage/deleteSuccess";
		}
	}
	
	//프로필 수정 o
	@RequestMapping(value="/editProfile", method=RequestMethod.GET)
	public String editProfile(Model model, HttpSession session,
			ProfileVo profileVo) {
		
		model.addAttribute("editProfile", new ProfileVo());
		
		profileVo.setNickname((String) session.getAttribute("loginVo"));
		model.addAttribute("profileVo", mapper.profileList((String) session.getAttribute("loginVo")));
		
		return "user/mypage/editProfile";
	}
	
	//프로필 수정 o
	@RequestMapping(value="/editProfile", method = RequestMethod.POST)
	public String editProfile(Model model, @ModelAttribute ProfileVo profileVo,
			BindingResult bindingResult, SessionStatus sessionStatus,HttpSession session) {
	
		if(bindingResult.hasErrors()) {
			return "/user/mypage/editProfile";
		}else {
			profileVo.setNickname((String) session.getAttribute("loginVo"));

			mapper.editProfile(profileVo);
			return "user/mypage/editProfileSuccess";
		}
		
		//model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
		
		//id 값을 받아야됨
		
	}

}
