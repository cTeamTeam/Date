package com.date.jum5.user.review.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.date.jum5.user.review.dao.ReviewDAO;
import com.date.jum5.user.review.util.FileUtils;
import com.date.jum5.user.review.vo.ReviewVo;
import com.date.jum5.user.review.vo.SearchCriteria;


@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Inject
	private ReviewDAO reviewdao;
	
	//게시글 목록 
	@Override
	public List<ReviewVo> list(SearchCriteria scri) throws Exception {
		return reviewdao.list(scri);
	}
	
	//첨부파일 조회
	@Override
	public List<Map<String , Object>> selectFileList(int seq) throws Exception {
		return reviewdao.selectFileList(seq);
	}
	
	//첨부파일 다운로드
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return reviewdao.selectFileInfo(map);
	}
	
	//게시글 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return reviewdao.listCount(scri);
	}
	
	//게시글 등록
	@Override
	public void reviewWriting(ReviewVo vo , MultipartHttpServletRequest request) throws Exception {
		
		vo.setSeq(reviewdao.getMaxSeq() + 1); //최대값에 +1
		
		reviewdao.reviewWriting(vo);
		
		List<Map<String,Object>> list = fileUtils.parselnsertFileInfo(vo, request);
		
		Map<String, Object> tempMap = null;
		int size = list.size();
		
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				reviewdao.insertFile(tempMap);
			}else {
				reviewdao.updateFile(tempMap);
			}

		}
	}
	
	//게시글 내용 보기
	@Override
	public ReviewVo view(int seq) {
		reviewdao.updateReadCount(seq);
		return reviewdao.view(seq);
	}
	//수정
	@Override
	public void update(ReviewVo vo, MultipartHttpServletRequest Request) throws Exception {
		
		reviewdao.update(vo);
		
		List<Map<String, Object>> list = fileUtils.parselnsertFileInfo(vo, Request);
		
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				reviewdao.insertFile(tempMap);
			}else {
				reviewdao.updateFile(tempMap);
			}
		}
	}
	//삭제
	public int delete(int seq) {
		return reviewdao.delete(seq);
	}
	
	//파일 삭제
	@Override
	public void fileDelete(int fileDel) throws Exception {
		reviewdao.fileDelete(fileDel);
	}
}































