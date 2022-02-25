package com.date.jum5.user.notice.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
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

import com.date.jum5.user.notice.service.NoticeService;
import com.date.jum5.user.notice.vo.NoticeVo;
import com.date.jum5.user.review.vo.Criteria;
import com.date.jum5.user.review.vo.PageMaker;
import com.date.jum5.user.review.vo.SearchCriteria;

@Controller
@RequestMapping("/user/notice")
public class NoticeController {
	
	@Inject
	NoticeService service;
	
	// 공지사항 글 작성 화면
	@RequestMapping(value = "/noticeForm", method = RequestMethod.GET)
	public String noticeView(NoticeVo vo, HttpServletRequest request) throws Exception{
		
		
		
		return "/user/notice/noticeForm";
	}
	
	// 공지사항 글 작성
	@RequestMapping(value = "/noticeWrite", method = RequestMethod.POST)
	public String noticewrite(NoticeVo vo, MultipartHttpServletRequest mpRequest, Model model, String[] fileDel) throws Exception{
		
		service.write(vo, mpRequest);
		
		return "redirect:/user/notice/noticeList";
		
	}
	//공지사항 목록
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public String noticeList(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
		List<NoticeVo> noticeList = service.noticeList(scri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.noticeCount(scri));
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageMaker" , pageMaker);
		
		System.out.println(noticeList + "노티스 리스트");
		
		
		return "/user/notice/noticeList";	
	}
	
	//공지사항 상세조회
	@RequestMapping(value = "/noticeView", method = RequestMethod.POST)
	public String read(NoticeVo vo, Model model, HttpServletRequest request, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		
		model.addAttribute("read", service.read(vo.getBno()));
		model.addAttribute("scri" , scri);
		
		List<Map<String, Object>> fileList = service.selectFileList(vo.getBno());
		model.addAttribute("file" , fileList); //파일 조회
		
		return "/user/notice/noticeView";
	}
	
	//공지사항 수정 페이지
	@RequestMapping(value = "/noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdate(NoticeVo vo, Model model, HttpServletRequest request) throws Exception {
		
		model.addAttribute("noticeUpdate", service.read(vo.getBno()));
		List<Map<String, Object>> fileList = service.selectFileList(vo.getBno());
		model.addAttribute("file", fileList);
		
		vo = service.read(Integer.parseInt(request.getParameter("bno")));
		model.addAttribute("read", vo);
		
		return "/user/notice/noticeUpdatePage";
	}
	
	//공지사항 수정
	@RequestMapping(value = "/noticeUpdateForm", method = RequestMethod.POST)
	public String noticeUpdateForm(NoticeVo vo, Model model, String[] fileDel, MultipartHttpServletRequest mpRequest) throws Exception {
		
		service.noticeUpdate(vo, mpRequest);
		
		if(fileDel != null) {
			for(int i = 0; i < fileDel.length; i++) {
				service.fileDelete(Integer.parseInt(fileDel[i]));
			}
		}
		
		return "redirect:/user/notice/noticeList";
	}
	
	//공지사항 삭제
	@RequestMapping(value = "/noticeDelete", method = RequestMethod.POST)
	public String noticeDelete(NoticeVo vo, Model model, HttpServletRequest request) throws Exception {
		
		service.noticeDelete(vo.getBno());
		
		return "redirect:/user/notice/noticeList";
	}
	
	//첨부파일 다운로드
	@RequestMapping(value = "/noticeFileDown")
	public void noticeFileDown(@RequestParam Map<String , Object> map , HttpServletResponse response) throws Exception {
		
		String path = "C:\\Users\\hp\\Desktop\\teamProject\\date\\date\\src\\main\\webapp\\WEB-INF\\noticeImage\\";
		
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

}





























