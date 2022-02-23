package com.date.jum5.manager.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.date.jum5.manager.pay.mapper.ManagerPayService;
import com.date.jum5.user.pay.vo.PayStateVo;

@Controller
public class ManagerPayController {

	private ManagerPayService managerPayService;
	
	@Autowired
	public void setManagerPayService(ManagerPayService managerPayService) {
		this.managerPayService = managerPayService;
	}
	
	@RequestMapping(value="/pay/list")
	public String payList(Model model, PayStateVo payStateVo) {
		model.addAttribute("payList", managerPayService.payList());
		return "/admin/pay/list";
	}
	
	@RequestMapping(value="/pay/search")
	public ModelAndView paySearchList(@RequestParam(defaultValue="idx")String searchOption,
			@RequestParam(defaultValue="")String keyword) throws Exception {
		List<PayStateVo> paySearchList = managerPayService.paySearchList(searchOption, keyword);
		int payCountArticle = managerPayService.payCountArticle(searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paySearchList", paySearchList);
		map.put("payCountArticle", payCountArticle);
		map.put("serchOption", searchOption);
		map.put("keyword", keyword);
		mav.addObject("map", map);
		mav.setViewName("/admin/pay/search");
		return mav;
	}
}
