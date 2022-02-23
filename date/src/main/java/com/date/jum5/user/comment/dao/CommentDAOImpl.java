package com.date.jum5.user.comment.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.comment.vo.CommentVo;

@Repository
public class CommentDAOImpl implements CommentDAO{

	@Inject 
	private SqlSession sql;
	
	private static final String NAMESPACE = "CommentMapper";
	
	//댓글 조회
	@Override
	public List<CommentVo> readReply(int rseq) throws Exception {
		return sql.selectList(NAMESPACE + ".readReply" , rseq);
	}
	// 댓글 작성
	@Override
	public void writeReply(CommentVo vo) throws Exception {
		sql.insert(NAMESPACE + ".writeReply" , vo);	
	}
	//댓글 수정
	@Override
	public int updateReply(CommentVo vo) throws Exception {
		return sql.update(NAMESPACE + ".updateReply" , vo);
	}
	//댓글 삭제
	@Override
	public void deleteReply(CommentVo vo) throws Exception {
		sql.delete(NAMESPACE + ".deleteReply" , vo);
		
	}
	//선택된 댓글 조회
	@Override
	public CommentVo selectReply(int rseq) throws Exception {
		return sql.selectOne(NAMESPACE + ".selectReply" , rseq);
	}
	
	
}