package com.date.jum5.manager.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.date.jum5.manager.member.mapper.ManagerMemberService;
import com.date.jum5.user.member.vo.MemberVo;

@Controller
public class ManagerMemeberController {
	
	@Inject
	ManagerMemberService managerMemberService;

	@RequestMapping(value="/admin/list", method=RequestMethod.GET)
	public String memberList(Model model) {
		List<MemberVo> list = managerMemberService.memberList();
		System.out.println(list.size());
		model.addAttribute("list", list);
		return "/admin/member/list";
	}
}
