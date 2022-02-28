package com.date.jum5.user.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.date.jum5.user.notice.vo.NoticeVo;
import com.date.jum5.user.review.vo.SearchCriteria;

public interface NoticeService {

	// 공지사항 작성
	public void write(NoticeVo vo, MultipartHttpServletRequest mpRequest) throws Exception;
	
	// 공지사항 조회
	public List<NoticeVo> noticeList(SearchCriteria scri) throws Exception;
	
	//첨부파일 조회
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
		
	//첨부파일 다운로드
	public Map<String , Object> selectFileInfo(Map<String , Object> map) throws Exception;
	
	//게시글 총 갯수
	public int noticeCount(SearchCriteria scri) throws Exception;
	
	// 공지사항 상세 조회
	public NoticeVo read(int bno) throws Exception;
	
	//공지사항 수정
	public void noticeUpdate(NoticeVo vo, MultipartHttpServletRequest mpRequest) throws Exception;
	//공지사항 삭제
	public int noticeDelete(int parseInt);
	
	//첨부 파일 삭제
	public void fileDelete(int fileDel) throws Exception;
}
