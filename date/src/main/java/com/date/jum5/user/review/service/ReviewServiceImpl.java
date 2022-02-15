package com.date.jum5.user.review.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.date.jum5.user.review.dao.ReviewDAO;
import com.date.jum5.user.review.util.FileUtils;
import com.date.jum5.user.review.vo.Criteria;
import com.date.jum5.user.review.vo.ReviewVo;


@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Inject
	private ReviewDAO reviewdao;
	
	//게시글 목록 
	@Override
	public List<ReviewVo> list(Criteria cri) throws Exception {
		return reviewdao.list(cri);
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
	public int listCount() throws Exception {
		return reviewdao.listCount();
	}
	
	//게시글 등록
	@Override
	public int reviewWriting(ReviewVo vo , MultipartHttpServletRequest request) throws Exception {

		vo.setSeq(reviewdao.getMaxSeq() + 1); //최대값에 +1
		
		List<Map<String,Object>> list = fileUtils.parselnsertFileInfo(vo, request);
		
		for(int i = 0; i < list.size(); i++) {
			reviewdao.insertFile(list.get(i));
		}

		return reviewdao.reviewWriting(vo);
	}
	
	//게시글 내용 보기
	@Override
	public ReviewVo view(int seq) {
		reviewdao.updateReadCount(seq);
		return reviewdao.view(seq);
	}
	//수정
	@Override
	public int update(ReviewVo vo) {
		return reviewdao.update(vo);
	}
	//삭제
	public int delete(int seq) {
		return reviewdao.delete(seq);
	}


}































