package com.date.jum5.user.question.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.date.jum5.manager.question.mapper.ManagerQuestionMapper;
import com.date.jum5.manager.question.vo.AdminQuestionVo;
import com.date.jum5.user.question.mapper.QuestionMapper;
import com.date.jum5.user.question.vo.PagingVo;
import com.date.jum5.user.question.vo.QuestionVo;

@Controller
public class QuestionController {
	
	private QuestionMapper questionMapper;
	private ManagerQuestionMapper managerQuestionMapper;
	
	@Autowired
	public QuestionController(QuestionMapper questionMapper, ManagerQuestionMapper managerQuestionMapper) {
		this.questionMapper = questionMapper;
		this.managerQuestionMapper=managerQuestionMapper;
	}
	
	//Q&A 리스트 요청 (o)
	@RequestMapping(value="/qaList")
	public String qaList(QuestionVo questionVo, Model model,
			@RequestParam(defaultValue="", required=false) String num,
			HttpServletRequest request) {
		
		Map<String, Integer> pageRowMap = new HashMap<>();
		
		String pageNum = request.getParameter("num");
		if (pageNum==null) {
			pageNum="1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		PagingVo paging = paging(currentPage);
		pageRowMap.put("start", paging.getStartRow());
		pageRowMap.put("end", paging.getEndRow());
		
		List<QuestionVo> questionList = questionMapper.questionAll(pageRowMap);
		model.addAttribute("page", paging);
		model.addAttribute("questionList", questionList);
		
		return "/user/question/questionList";
	}
	
	//페이징 계산
	public PagingVo paging(int currentPage) {
		
		PagingVo paging = new PagingVo();
		
		int pageSize = paging.getPageSize();
		int startRow = 1 + (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		
		int count = questionMapper.questionCount();
		
		int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
		
		int pageBlock = paging.getPageBlock();
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage + pageBlock - 1;
		int realEndPage = (count/10)+1;
		
		if ((count%10)==0) {
			realEndPage = (count/10);
		} else {
			realEndPage = (count/10)+1;
		}
		
		if (endPage > realEndPage) {
			endPage = realEndPage;
		}
		paging.setCurrentPage(currentPage);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setPageCount(pageCount);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		
		return paging;
		
	}
	
	//Q&A 작성 폼 요청 (o)
	@RequestMapping(value="/qaWrite", method=RequestMethod.GET)
	public String qaWriteForm(Model model, HttpSession session) {
		model.addAttribute("qaWrite", new QuestionVo());
		
		return "/user/question/questionWrite";
	}
	
	//Q&A 작성 성공 요청 (o)
	@RequestMapping(value="/qaWrite", method=RequestMethod.POST)
	public String qaWriteSuccess(@ModelAttribute("qaWrite") QuestionVo question,
			HttpSession session, Model model) {

		question.setId((String) session.getAttribute("loginVo"));
		
		questionMapper.questionWrite(question);
		
		model.addAttribute("qa", 3);
		return "/user/question/questionAlert";
		
	}
	
	//Q&A 내용 요청 (o)
	@RequestMapping(value="/qaContent")
	public String qaContent(@RequestParam("qaNum")int qaNum,
			Model model) {
		
		//조회수 증가
		questionMapper.qaCount(qaNum);
		
		QuestionVo qaContent = questionMapper.qaContent(qaNum);
		
		AdminQuestionVo qaAnswer = managerQuestionMapper.answer(qaNum);
		
		System.out.println(qaAnswer);
		
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("qaAnswer", qaAnswer);
		
		return "/user/question/questionContent";
	}
	
	//자기 Q&A삭제
	@RequestMapping(value="/qaDelete")
	public String qaDelete(@RequestParam("qaNum") int qaNum,
			Model model) {
		
		questionMapper.qaDelete(qaNum);
		model.addAttribute("qa", 1);
		return "/user/question/questionAlert";
	}
	
	//Q&A 수정 폼 요청 (o)
	@RequestMapping(value="/qaModify", method=RequestMethod.GET)
	public String qaModify(Model model, @RequestParam("qaNum") int qaNum) {
		model.addAttribute("qaModify", new QuestionVo());
		
		QuestionVo qaModify = questionMapper.qaContent(qaNum);
		model.addAttribute("modify", qaModify);
		return "/user/question/questionModify";
	}
	
	//Q&A 수정 성공 (o)
	@RequestMapping(value="/qaModify", method=RequestMethod.POST)
	public String qaModifySuccess(@ModelAttribute("qaModify") QuestionVo question,
			@RequestParam("qaNum") int qaNum, Model model) {
		
		question.setNum(qaNum);
		
		questionMapper.qaModify(question);
		model.addAttribute("qa", 2);
		return "/user/question/questionAlert";
	}
	
	//Q&A 검색 (o)
	@RequestMapping(value="/qaSearch", method=RequestMethod.GET)
	public String qaSearch(@RequestParam("keyword") String keyword,
			@RequestParam("searchType") String searchType,
			@RequestParam(defaultValue="", required=false) String num,
			HttpServletRequest request, Model model) {
				
		Map<String, Object> searchMap = new HashMap<>();
		
		String pageNum = request.getParameter("num");
		if (pageNum==null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		
		PagingVo paging = searchPaging(currentPage, keyword, searchType);
		searchMap.put("start", paging.getStartRow());
		searchMap.put("end", paging.getEndRow());
		searchMap.put("keyword", keyword);
				
		
		if (searchType.equals("title")) {
			
			List<QuestionVo> searchList = questionMapper.titleSearch(searchMap);
			model.addAttribute("searchList", searchList);
		
		} else if (searchType.equals("content")) {
		
			List<QuestionVo> searchList = questionMapper.contentSearch(searchMap);
			model.addAttribute("searchList", searchList);
			
		} else {
			
			List<QuestionVo> searchList = questionMapper.writerSearch(searchMap);
			model.addAttribute("searchList", searchList);
		}

		model.addAttribute("type", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", paging);
		
		return "/user/question/questionSearch";
	}
	
	//검색 페이징 계산 (o)
	public PagingVo searchPaging(int currentPage, String keyword, String searchType) {
		
		int count = 0;
		
		PagingVo paging = new PagingVo();
			
		int pageSize = paging.getPageSize();
		int startRow = 1 + (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		
		if (searchType.equals("title")) {
			count = questionMapper.searchTitleCount(keyword);
		} else if (searchType.equals("content")) {
			count = questionMapper.searchContentCount(keyword);
		} else {
			count = questionMapper.searchIdCount(keyword);
		}
			
		int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
			
		int pageBlock = paging.getPageBlock();
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage + pageBlock - 1;
		int realEndPage = (count/10)+1;
			
		if ((count%10)==0) {
			realEndPage = (count/10);
		} else {
			realEndPage = (count/10)+1;
		}
			
		if (endPage > realEndPage) {
			endPage = realEndPage;
		}
		paging.setCurrentPage(currentPage);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setPageCount(pageCount);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
			
		return paging;
			
	}

}
