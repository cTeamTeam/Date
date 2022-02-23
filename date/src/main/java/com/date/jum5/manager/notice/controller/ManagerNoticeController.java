package com.date.jum5.manager.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.date.jum5.manager.notice.mapper.ManagerNoticeService;
import com.date.jum5.manager.notice.vo.ManagerNoticeVo;

@Controller
public class ManagerNoticeController {
	
	private ManagerNoticeService managerNoticeService;
	
	@Autowired
	public void setManagerNoticeService(ManagerNoticeService managerNoticeService) {
		this.managerNoticeService = managerNoticeService;
	}
	
	@RequestMapping(value="/notice/list")
	public String noticeList(Model model, ManagerNoticeVo managerNoticeVo) {
		model.addAttribute("noticelist", managerNoticeService.noticeList());
		return "/admin/notice/list";
	}
	
	@RequestMapping(value="/notice/read/{num}")
	public String read(Model model, @PathVariable int num) {
		model.addAttribute("managerNoticeVo", managerNoticeService.read(num));
		return "/admin/notice/read";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.GET)
	public String write() {
		return "/admin/notice/write";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.POST)
	public String write(ManagerNoticeVo managerNoticeVo) {
		managerNoticeService.write(managerNoticeVo);
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="/notice/edit/{num}", method=RequestMethod.GET)
	public String edit(@PathVariable int num, Model model) {
		ManagerNoticeVo managerNoticeVo = managerNoticeService.read(num);
		model.addAttribute("managerNoticeVo", managerNoticeVo);
		return "/admin/notice/edit";
	}
	
	@RequestMapping(value="/notice/edit/{num}", method=RequestMethod.POST)
	public String edit(ManagerNoticeVo managerNoticeVo, Model model) {
		managerNoticeService.edit(managerNoticeVo);
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="/notice/delete/{num}", method=RequestMethod.GET)
	public String delete(@PathVariable int num, Model model) {
		model.addAttribute("num", num);
		return "/admin/notice/delete";
	}
	
	@RequestMapping(value="/notice/delete", method=RequestMethod.POST)
	public String delete(ManagerNoticeVo managerNoticeVo, Model model) {
		managerNoticeService.delete(managerNoticeVo);
		return "redirect:/notice/list";		
	}
	
	@RequestMapping(value="/notice/search")
	public ModelAndView list(@RequestParam(defaultValue = "title")String searchOption, 
			@RequestParam(defaultValue="")String keyword) throws Exception{
		List<ManagerNoticeVo> list = managerNoticeService.searchList(searchOption, keyword);
		int count = managerNoticeService.countArticle(searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		mav.addObject("map", map);
		mav.setViewName("/admin/notice/search");
		return mav;
	}
}
