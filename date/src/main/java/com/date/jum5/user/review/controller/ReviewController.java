package com.date.jum5.user.review.controller;


import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.date.jum5.user.comment.service.CommentService;
import com.date.jum5.user.comment.vo.CommentVo;
import com.date.jum5.user.review.service.ReviewService;
import com.date.jum5.user.review.vo.PageMaker;
import com.date.jum5.user.review.vo.ReviewVo;
import com.date.jum5.user.review.vo.SearchCriteria;


@Controller
@RequestMapping(value="/user/review")
public class ReviewController {
	
	@Inject
	private ReviewService service;
	
	@Inject
	private CommentService commentService;
	
	//게시글 조회
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String list(Model model , @ModelAttribute("scri") SearchCriteria scri ) throws Exception {
	
		List<ReviewVo> list = service.list(scri);	

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		System.out.println("=====================");
		System.out.println(scri.getPerPageNum());
		System.out.println(scri.getPage());
		System.out.println("=====================");
		
		model.addAttribute("list" , list);
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "/user/review/list";
	}
	
	//게시글 작성 폼 이동
	@RequestMapping(value = "/reviewForm", method = RequestMethod.GET)
	public String reviewForm(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		model.addAttribute("loginVo", session.getAttribute("loginVo"));
		
		return "/user/review/reviewForm";
	}
	
	//게시글 작성
	@ResponseBody
	@RequestMapping(value = "/reviewWriting", method = RequestMethod.POST)
	public Map<String, Object> reviewWriting(Model model, ReviewVo vo , MultipartHttpServletRequest request ) throws Exception{

		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		if(service.reviewWriting(vo, request) == 1) {
			returnMap.put("result", "Y");	
		}else {
			returnMap.put("result", "N");
		}
		
		return returnMap;
	}
	
	//게시글 내용 보기
	@RequestMapping(value = "/view")
	public String view(Model model , HttpServletRequest request , ReviewVo vo ,@ModelAttribute("scri") SearchCriteria scri ) throws Exception{
		
		
		List<Map<String, Object>> fileList = service.selectFileList(vo.getSeq());
		model.addAttribute("file" , fileList); //파일 조회
		try {
			List<CommentVo> replyList = commentService.readReply(vo.getSeq());
			model.addAttribute("replyList", replyList); // 댓글 조회
		}catch(Exception e) {
			e.printStackTrace();
		}
		vo = service.view(Integer.parseInt(request.getParameter("seq")));
		System.out.println(request.getParameter("result"));
		model.addAttribute("result", request.getParameter("result"));
		model.addAttribute("scri" , scri);
		model.addAttribute("view" , vo); // 게시글 조회
		
		
		return "/user/review/view";
	}
	
	
	//게시글 수정 페이지
	@RequestMapping(value = "/goUpdateView" , method = RequestMethod.POST)
	public String updateView(Model model , HttpServletRequest request , ReviewVo vo ,@ModelAttribute("scri") SearchCriteria scri ) throws Exception {
		
		
		model.addAttribute("update", service.view(vo.getSeq()));
		model.addAttribute("scri", scri);
		List<Map<String, Object>> fileList = service.selectFileList(vo.getSeq());
		model.addAttribute("file", fileList);
		
		vo = service.view(Integer.parseInt(request.getParameter("seq")));
		model.addAttribute("view" , vo);
		
		return "/user/review/update";
	}
	
	//게시글 수정 
	@ResponseBody
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String update(Model model, ReviewVo vo , @ModelAttribute("scri") SearchCriteria scri ,RedirectAttributes rttr) throws Exception {
		
		service.update(vo);
		
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/user/review/list";
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
		
		String path = "C:\\Users\\hp\\Desktop\\teamProject\\date\\date\\src\\main\\webapp\\WEB-INF\\image\\";
		
		Map<String , Object> resultMap = service.selectFileInfo(map);
		
		String filePath = path + (String) resultMap.get("STORED_FILE_NAME"); //파일 전체경로(파일명도 포함)
	    String oriFileName = (String) resultMap.get("ORG_FILE_NAME"); //파일 원본 경로
	    
	    String docName = URLEncoder.encode(oriFileName,"UTF-8").replaceAll("\\+", "%20"); //한글파일명 깨지지 않도록
	    
	    response.setHeader("Content-Disposition", "attachment;filename=" + docName);
	    
	    FileInputStream fileInputStream = new FileInputStream(filePath);
		OutputStream out = response.getOutputStream();
		
		int read = 0;
		byte[] buffer = new byte[1024];
		while ((read = fileInputStream.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
	}
	
	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String replyWrite(CommentVo vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		 commentService.writeReply(vo);
		 rttr.addAttribute("seq", vo.getSeq());
		 rttr.addAttribute("page", scri.getPage());
		 rttr.addAttribute("perPageNum", scri.getPerPageNum());
		 rttr.addAttribute("searchType", scri.getSearchType());
		 rttr.addAttribute("keyword", scri.getKeyword());
		 
	 return "redirect:/user/review/view"; 
	}
	
	//댓글 수정 GET
		@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(CommentVo vo, SearchCriteria scri, Model model) throws Exception {
			
			model.addAttribute("replyUpdate", commentService.selectReply(vo.getRseq()));
			model.addAttribute("scri", scri);
			
			return "/user/review/replyUpdateView";
	}
		
		//댓글 수정 POST
		@RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
		public String replyUpdate(CommentVo vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			int result = commentService.updateReply(vo);
			
			rttr.addAttribute("result", result);
			rttr.addAttribute("seq", vo.getSeq());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/user/review/view";
	}
		//댓글 삭제 GET
		@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(CommentVo vo, SearchCriteria scri, Model model) throws Exception {
			
			model.addAttribute("replyDelete", commentService.selectReply(vo.getRseq()));
			model.addAttribute("scri", scri);
			

			return "/user/review/replyDeleteView";
		}
		
		//댓글 삭제
		@RequestMapping(value="/replyDelete", method = RequestMethod.POST)
		public String replyDelete(CommentVo vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			commentService.deleteReply(vo);
			
			rttr.addAttribute("seq", vo.getSeq());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/user/review/view";
		}
	
		


}




























