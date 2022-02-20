package com.date.jum5.user.comment.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.date.jum5.user.comment.dao.CommentDAO;
import com.date.jum5.user.comment.vo.CommentVo;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Inject
	private CommentDAO dao;
	
	//댓글 조회
	@Override
	public List<CommentVo> readReply(int rseq) throws Exception {
		return dao.readReply(rseq);
	}
	//댓글 작성
	@Override
	public void writeReply(CommentVo vo) throws Exception {
		dao.writeReply(vo);
		
	}
	//댓글 수정
	@Override
	public int updateReply(CommentVo vo) throws Exception {
		return dao.updateReply(vo);	
	}
	//댓글 삭제
	@Override
	public void deleteReply(CommentVo vo) throws Exception {
		dao.deleteReply(vo);
		
	}
	//선택된 댓글 조회
	@Override
	public CommentVo selectReply(int rseq) throws Exception {
		return dao.selectReply(rseq);
	}
}
