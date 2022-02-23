package com.date.jum5.manager.question.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.date.jum5.manager.question.mapper.ManagerQuestionMapper;
import com.date.jum5.manager.question.vo.AdminQuestionVo;
import com.date.jum5.user.question.mapper.QuestionMapper;
import com.date.jum5.user.question.vo.PagingVo;
import com.date.jum5.user.question.vo.QuestionVo;

@Controller 
public class ManagerQuestionController {

	private QuestionMapper questionMapper;
	private ManagerQuestionMapper managerQuestionMapper;
	
	@Autowired
	public ManagerQuestionController(QuestionMapper questionMapper, ManagerQuestionMapper managerQuestionMapper) {
		this.questionMapper = questionMapper;
		this.managerQuestionMapper=managerQuestionMapper;
	}
	
	@RequestMapping(value="/adminQA", method=RequestMethod.GET)
	public String adminQuestion(@RequestParam(defaultValue="", required=false) String num,
			HttpServletRequest request, Model model) {
		
		Map<String, Integer> pageRowMap = new HashMap<>();
		
		String pageNum = request.getParameter("num");
		if (pageNum==null) {
			pageNum="1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		System.out.println(currentPage);
		
		PagingVo paging = paging(currentPage);
		pageRowMap.put("start", paging.getStartRow());
		pageRowMap.put("end", paging.getEndRow());
				
		List<QuestionVo> questionList = questionMapper.questionAll(pageRowMap);
		model.addAttribute("page", paging);
		model.addAttribute("questionList", questionList);
		
		return "admin/question/adminQuestion";
	}
	
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
	
	@RequestMapping(value="/adminQASearch", method=RequestMethod.GET)
	public String adminQASearch(@RequestParam("keyword") String keyword,
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

		return "/admin/question/adminQASearch";
	}
		
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
	
	@RequestMapping(value="/adminQAContent")
	public String adminQAContent(@RequestParam("qaNum") int qaNum,
			Model model) {
		
		QuestionVo qaContent = questionMapper.qaContent(qaNum);
		
		AdminQuestionVo qaAnswer = managerQuestionMapper.answer(qaNum);
		
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("qaAnswer", qaAnswer);
		
		return "/admin/question/adminQAContent";
	}
	
	
	//자기 Q&A삭제
	@RequestMapping(value="/adminQADelete")
	public String qaDelete(@RequestParam("qaNum") int qaNum,
			Model model) {
			
		questionMapper.qaDelete(qaNum);
		model.addAttribute("qa", 1);
		return "/admin/question/adminQAalert";
	}
	
	@RequestMapping(value="/adminAnswer", method=RequestMethod.POST)
	public String adminAnswer(@RequestParam("qaNum") int qaNum,
			HttpServletRequest request, AdminQuestionVo adminQuestionVo,
			Model model) {
		
		String answer = request.getParameter("answer");
		
		adminQuestionVo.setAnswer(answer);
		adminQuestionVo.setQaNum(qaNum);
		
		managerQuestionMapper.insertAnswer(adminQuestionVo);
		
		managerQuestionMapper.updateState(qaNum);
		
		model.addAttribute("qa", 2);
		return "/admin/question/adminQAalert";
	}
	
	//답변 삭제=
	@RequestMapping(value="/answerDelete")
	public String answerDelte(@RequestParam("qaNum") int qaNum,
			Model model) {
		
		
		managerQuestionMapper.answerDelete(qaNum);
		managerQuestionMapper.deleteUpdateState(qaNum);
		model.addAttribute("qa", 3);
		
		return "/admin/question/adminQAalert";
	}
	
	//답변 수정 폼 요청
	@RequestMapping(value="/answerModify", method=RequestMethod.GET)
	public String answerModify(@RequestParam("qaNum") int qaNum,
			Model model) {
		
		QuestionVo qaContent = questionMapper.qaContent(qaNum);
		
		AdminQuestionVo qaAnswer = managerQuestionMapper.answer(qaNum);
		
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("qaAnswer", qaAnswer);
		
		
		return "/admin/question/adminQAModify";
	}
	
	@RequestMapping(value="/answerModify", method=RequestMethod.POST)
	public String answerModifySuccess(@RequestParam("qaNum") int qaNum,
			Model model, HttpServletRequest request, AdminQuestionVo adminQuestionVo) {
		
		System.out.println("번호 : "+qaNum);
		String answer = request.getParameter("answer");
		System.out.println("바뀐 답변 : "+answer);
		
		adminQuestionVo.setQaNum(qaNum);
		adminQuestionVo.setAnswer(answer);
		
		managerQuestionMapper.modifyAnswer(adminQuestionVo);
		model.addAttribute("qa", 4);
		
		return "/admin/question/adminQAalert";
	}
		
}
