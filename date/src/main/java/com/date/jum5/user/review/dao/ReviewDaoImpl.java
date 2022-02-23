package com.date.jum5.user.review.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.date.jum5.user.review.vo.ReviewVo;
import com.date.jum5.user.review.vo.SearchCriteria;

@Repository
public class ReviewDaoImpl implements ReviewDao{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "ReviewMapper";
	
	// 게시글 조회
	@Override
	public List<ReviewVo> list(SearchCriteria scri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".list" , scri);
	}
	
	//게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listCount", scri);
	}
	
	//게시글 카운트
	@Override
	public Integer getMaxSeq() {
		return sqlSession.selectOne(NAMESPACE+".maxSeq");
	}
	//게시글 등록
	@Override
	public int reviewWriting(ReviewVo vo) {
		return sqlSession.insert(NAMESPACE + ".reviewWriting" , vo);
	}
	//게시글 내용 보기
	@Override
	public ReviewVo view(int seq) {
		return sqlSession.selectOne(NAMESPACE + ".view" , seq);
	}
	//게시글 조회수 증가
	@Override
	public void updateReadCount(int seq) {
		sqlSession.update(NAMESPACE + ".updateReadCount" , seq);
	}
	
	//게시글 수정
	@Override
	public int update(ReviewVo vo) {
		return sqlSession.update(NAMESPACE + ".update" , vo);
	}
	
	//게시글 삭제
	@Override
	public int delete(int seq) {
		return sqlSession.update(NAMESPACE + ".delete" , seq);
	}
	
	//첨부파일 업로드
	@Override
	public void insertFile(Map<String , Object>map) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertFile", map);
	}
	
	//첨부파일 조회 
	@Override
	public List<Map<String , Object>> selectFileList(int seq) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectFileList" , seq);
	}
	
	//첨부파일 다운로드
	@Override
	public Map<String , Object> selectFileInfo(Map<String , Object> map) throws Exception{
		return sqlSession.selectOne(NAMESPACE + ".selectFileInfo" , map);
	}

	@Override
	public void updateFile(Map<String, Object> map) throws Exception {
		sqlSession.update(NAMESPACE + ".updateFile" , map);
		
	}
}