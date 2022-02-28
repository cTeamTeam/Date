package com.date.jum5.user.notice.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.notice.vo.NoticeVo;
import com.date.jum5.user.review.vo.SearchCriteria;

@Repository
public class NoticeDaoImpl implements NoticeDao {

		@Inject
		private SqlSession sqlSession;
		
		private static final String NAMESPACE = "NoticeMapper";

		// 공지사항 작성
		@Override
		public int write(NoticeVo vo) throws Exception {
			return sqlSession.insert(NAMESPACE + ".noticeInsert", vo);
			
		}
		//공지사항 목록
		@Override
		public List<NoticeVo> noticeList(SearchCriteria scri) throws Exception {
			return sqlSession.selectList(NAMESPACE + ".noticelist", scri);
		}
		
		//게시물 총 갯수
		@Override
		public int noticeCount(SearchCriteria scri) throws Exception {
			return sqlSession.selectOne(NAMESPACE + ".noticeCount", scri);
		}
		// 공지사항 상세보기
		@Override
		public NoticeVo read(int bno) throws Exception {
			return sqlSession.selectOne(NAMESPACE + ".read" , bno);
		}
		// 공지사항 수정
		@Override
		public int noticeUpdate(NoticeVo vo) {
			return sqlSession.update(NAMESPACE + ".noticeUpdate" , vo);
		}
		
		//공지사항 삭제
		@Override
		public int noticeDelete(int bno) {
			return sqlSession.delete(NAMESPACE + ".noticeDelete" , bno);
		}
		
		//게시글 카운트
		@Override
		public Integer getMaxBno() {
			return sqlSession.selectOne(NAMESPACE + ".maxBno");
		}
		
		//첨부파일 업로드
		@Override
		public void insertFile(Map<String, Object> map) throws Exception {
			sqlSession.insert(NAMESPACE + ".insertFile", map);	
		}
		//첨부파일 조회 
		@Override
		public List<Map<String , Object>> selectFileList(int bno) throws Exception {
			return sqlSession.selectList(NAMESPACE + ".selectFileList" , bno);
		}
		
		//첨부파일 다운로드
		@Override
		public Map<String , Object> selectFileInfo(Map<String , Object> map) throws Exception{
			return sqlSession.selectOne(NAMESPACE + ".selectFileInfo" , map);
		}
		
		//첨부파일 수정
		@Override
		public void updateFile(Map<String, Object> map) throws Exception {
			sqlSession.update(NAMESPACE + ".updateFile" , map);
			
		}
		
		//첨부파일 삭제
		@Override
		public void fileDelete(int fileDel) throws Exception {
			sqlSession.delete(NAMESPACE + ".fileDelete" , fileDel);
		}
		
}
