package com.date.jum5.user.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.date.jum5.user.review.vo.ReviewVo;
import com.date.jum5.user.review.vo.SearchCriteria;




public interface ReviewService {

	// 게시글 조회
	public List<ReviewVo> list(SearchCriteria scri) throws Exception;
	
	//첨부파일 조회
	public List<Map<String, Object>> selectFileList(int seq) throws Exception;
	
	//첨부파일 다운로드
	public Map<String , Object> selectFileInfo(Map<String , Object> map) throws Exception;

	//게시글 총 갯수
	public int listCount(SearchCriteria scri) throws Exception;
	
	//게시글 등록
	int reviewWriting(ReviewVo vo, MultipartHttpServletRequest request) throws Exception;
	//게시글 보기
	ReviewVo view(int seq);
	//게시글 수정
	int update(ReviewVo vo);
	//게시글 삭제
	public int delete(int parseInt);

	


}