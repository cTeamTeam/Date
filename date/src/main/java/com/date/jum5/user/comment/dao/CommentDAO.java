package com.date.jum5.user.comment.dao;

import java.util.List;

import com.date.jum5.user.comment.vo.CommentVo;

public interface CommentDAO {

	//댓글 조회
	public List<CommentVo> readReply(int rseq) throws Exception;
	
	//댓글 작성
	public void writeReply(CommentVo vo) throws Exception;
	
	//댓글 수정
	public int updateReply(CommentVo vo) throws Exception;
	
	//댓글 삭제
	public void deleteReply(CommentVo vo) throws Exception;
	
	//선택된 댓글 조회
	public CommentVo selectReply(int rseq) throws Exception;
}