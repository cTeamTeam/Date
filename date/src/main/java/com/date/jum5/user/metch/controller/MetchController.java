package com.date.jum5.user.metch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.date.jum5.user.metch.dao.MetchDao;
import com.date.jum5.user.metch.mapper.MetchMapper;
import com.date.jum5.user.metch.vo.MetchVo;

@Controller
@SessionAttributes("loginVo")
public class MetchController {
	
	@Autowired
	MetchMapper mapper;
	
	@Autowired
	MetchDao dao;
	
	//이성의 모든 리스트를 반환
	@RequestMapping(value="/metch", method=RequestMethod.GET)
	public String metchList(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId =(String)session.getAttribute("loginVo");
		
		if (userId==null) {
			model.addAttribute("msg", 1);
			return "/user/metch/metchAlert";
		}
		
		
		String gender = mapper.GetGender(userId);
		System.out.println(gender);
		String matchingGender;
		
		if(gender.equals("남자")) {
			matchingGender = "남자";
		}
		else {
			matchingGender = "여자";
		}
		
		model.addAttribute("profileVo", mapper.MetchList(matchingGender));
		System.out.println(mapper.MetchList(matchingGender).size());
		return "/user/metch/metch";
	}
	
	//데이트 신청하기
	@RequestMapping(value="/request/{id}",method=RequestMethod.GET)
	public String request(Model model, @PathVariable String id,HttpServletRequest request,MetchVo metchVo) {
		HttpSession session = request.getSession();
		String userId =(String)session.getAttribute("loginVo");
		metchVo.setSenderId(userId);
		metchVo.setReceiverId(id);
		System.out.println("신청하는 아이디 : "+userId);
		System.out.println("신청 받는 아이디 : "+id);
		mapper.requestDate(metchVo);
		model.addAttribute("msg", 2);
		return "user/metch/metchAlert";
	}
	
	
	
	
	
	
	//신청 현황 보기
	@RequestMapping(value="/metchList", method=RequestMethod.GET)
	public String requestList(Model model, HttpServletRequest request, MetchVo metchVo) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("loginVo");
		System.out.println(userId);
		List<MetchVo> ls = mapper.RequestList(userId);
		model.addAttribute("requestList", ls);
		
		return "user/metch/requestList";
	}
	

	//나한테 요청한 사람 보기
	@RequestMapping(value="/beRequested", method=RequestMethod.GET)
	public String beRequestedList(Model model,HttpServletRequest request,
			HttpSession session) {
		
		String userId =(String)session.getAttribute("loginVo");
		System.out.println(userId);
		model.addAttribute("metchVo",mapper.beRequested(userId));
		return "user/metch/beRequestedList";
	}
	
	//데이트 수락하기
	@RequestMapping(value="/accept")
	public String requestedAccept(@ModelAttribute MetchVo metchVo,
			Model model, HttpServletRequest request,
			@RequestParam("idx") int idx) {
		HttpSession session = request.getSession();
		String userId =(String)session.getAttribute("loginVo");
		System.out.println(idx);
		//1 -> 수략, -1 -> 거절
		System.out.println(metchVo.getMetchStatus());
		System.out.println(metchVo.getIdx());
		System.out.println(metchVo);
		model.addAttribute("metchVO", idx);
		if(metchVo.getMetchStatus() == 1) {
			mapper.requestedAccept(idx);
			return "user/metch/metchSuccess";
		} else if(metchVo.getMetchStatus() == -1) {
			mapper.requestedDeny(idx);	
			return "user/metch/metchSuccess";
		}
		return "user/mypage/myPage";

	}
	
	//신청자 상세 프로필 보기
	@RequestMapping(value="/readProfile/{senderId}")
	public String readProfile(Model model, @PathVariable String senderId,MetchVo metchVo) {
		senderId=metchVo.getSenderId();
		model.addAttribute("profileVo",mapper.readProfile(senderId));
		return "/user/metch/readProfile";
	}
	

	
	
}
