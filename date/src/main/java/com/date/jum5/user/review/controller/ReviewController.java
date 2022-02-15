package com.date.jum5.user.review.controller;


import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.date.jum5.user.review.service.ReviewService;
import com.date.jum5.user.review.vo.Criteria;
import com.date.jum5.user.review.vo.PageMaker;
import com.date.jum5.user.review.vo.ReviewVo;
import com.google.common.io.ByteStreams;


@Controller
@RequestMapping(value="/user/review")
public class ReviewController {
	
	@Inject
	private ReviewService service;
	
	//게시글 조회
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String list(Model model , Criteria cri ) throws Exception {
	
		List<ReviewVo> list = service.list(cri);	

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		
		
		model.addAttribute("list" , list);
		model.addAttribute("pageMaker", pageMaker);
		
		return "/user/review/list";
	}
	
	//게시글 작성 폼 이동
	@RequestMapping(value = "/reviewForm", method = RequestMethod.GET)
	public String reviewForm(Locale locale, Model model) throws Exception {
		
		return "/user/review/reviewForm";
	}
	//게시글 작성
	@ResponseBody
	@RequestMapping(value = "/reviewWriting", method = RequestMethod.POST)
	public Map<String, Object> reviewWriting(Locale locale, Model model, ReviewVo vo , MultipartHttpServletRequest request ) throws Exception{

		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		if(service.reviewWriting(vo, request) == 1) {
			returnMap.put("result", "Y");	
		}else {
			returnMap.put("result", "N");
		}
		
		return returnMap;
	}
	
	//게시글 내용 보기
	@RequestMapping(value = "/view" , method = RequestMethod.POST)
	public String view(Locale local , Model model , HttpServletRequest request , ReviewVo vo) throws Exception{
		
		List<Map<String, Object>> fileList = service.selectFileList(vo.getSeq());
		model.addAttribute("file" , fileList);
		
		vo = service.view(Integer.parseInt(request.getParameter("seq")));
		model.addAttribute("view" , vo);
		
		return "/user/review/view";
	}
	
	//게시글 수정 페이지
	@RequestMapping(value = "/goUpdateView" , method = RequestMethod.POST)
	public String updateView(Locale locale , Model model , HttpServletRequest request) throws Exception {
		
		System.out.println("!!");
		System.out.println(request.getParameter("seq"));
		ReviewVo vo = service.view(Integer.parseInt(request.getParameter("seq")));
		
		System.out.println(vo);
		
		
		model.addAttribute("view" , vo);
		
		return "/user/review/update";
	}
	
	//게시글 수정 
	@ResponseBody
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String update(Locale locale, Model model, ReviewVo vo) throws Exception {
		
	
		
		if(service.update(vo) == 1) {
			System.out.println("Y");
			return "Y";
		}else {
			System.out.println("N");
			return "N";
		}
	}
	
	//게시글 삭제
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		if(service.delete(Integer.parseInt((String)request.getParameter("seq"))) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	//파일 다운로드
	@RequestMapping(value = "/fileDownLoad")
	public void fileDownLoad(@RequestParam Map<String , Object> map , HttpServletResponse response) throws Exception {
		
		System.out.println(map.toString());
		
		Map<String , Object> resultMap = service.selectFileInfo(map);
		
		String stredFileName = (String) resultMap.get("STORED_FILE_NAME");
		String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
		
		File fileDown = new File (originalFileName);
		FileInputStream fileIn = new FileInputStream(fileDown);
		ByteStreams.copy(fileIn , response.getOutputStream());
		response.flushBuffer();
		
		
	}	
}
