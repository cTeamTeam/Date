package com.date.jum5.manager.metch.controller;

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

import com.date.jum5.manager.metch.mapper.ManagerMetchService;
import com.date.jum5.user.metch.vo.MetchVo;

@Controller
public class ManagerMetchController {

	private ManagerMetchService managerMetchService;
	
	@Autowired
	public void setManagerMetchService(ManagerMetchService managerMetchService) {
		this.managerMetchService = managerMetchService;
	}
	
	@RequestMapping(value="/metch/allList")
	public String metchAllList(Model model, MetchVo metchVo) {
		model.addAttribute("metchAllList", managerMetchService.metchAllList());
		return "/admin/metch/allList";
	}
	
	@RequestMapping(value="/metch/read/{idx}")
	public String read(Model model, @PathVariable int idx) {
		model.addAttribute("metchVo", managerMetchService.read(idx));
		return "/admin/metch/read";
	}
	
	@RequestMapping(value="/metch/delete/{idx}", method=RequestMethod.GET)
	public String delete(@PathVariable int idx, Model model) {
		model.addAttribute("idx", idx);
		return "/admin/metch/delete";
	}
	
	@RequestMapping(value="/metch/delete", method=RequestMethod.POST)
	public String delete(MetchVo metchVo, Model model) {
		managerMetchService.delete(metchVo);
		return "redirect:/metch/allList";
	}
	
	@RequestMapping(value="/metch/selectList")
	public String metchList(Model model, MetchVo metchVo) {
		model.addAttribute("metchSelect", managerMetchService.metchList());
		return "/admin/metch/selectList";
	}
	
	@RequestMapping(value="/metch/search")
	public ModelAndView metchList(@RequestParam(defaultValue = "idx")String searchOption, 
			@RequestParam(defaultValue="")String keyword) throws Exception{
		List<MetchVo> metchList = managerMetchService.metchSearchList(searchOption, keyword);
		int metchCount = managerMetchService.metchCountArticle(searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("metchList", metchList);
		map.put("metchCount", metchCount);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		mav.addObject("map", map);
		mav.setViewName("/admin/metch/search");
		return mav;
	}
	
}
