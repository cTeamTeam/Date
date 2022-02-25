package com.date.jum5.user.notice.dao;

import java.util.List;
import java.util.Map;

import com.date.jum5.user.notice.vo.NoticeVo;
import com.date.jum5.user.review.vo.SearchCriteria;

public interface NoticeDao {
	
	// 공지사항 작성
	public int write(NoticeVo vo) throws Exception;
		
	// 공지사항 목록
	public List<NoticeVo> noticeList(SearchCriteria scri) throws Exception;
	
	//게시글 총 갯수
	public int noticeCount(SearchCriteria scri) throws Exception;
	
	// 공지사항 상세조회
	public NoticeVo read(int bno) throws Exception;
	
	//게시글 수정
	public int noticeUpdate(NoticeVo vo);
		
	//게시글 삭제
	public int noticeDelete(int bno);
	
	//게시글 bno 맥스
	public Integer getMaxBno();
	
	//첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;
	
	//첨부파일 조회
	public List<Map<String , Object>> selectFileList(int bno) throws Exception ;
		
	//첨부파일 다운로드
	public Map<String , Object> selectFileInfo(Map<String , Object> map) throws Exception;
		
	//첨부파일 수정
	public void updateFile(Map<String , Object> map) throws Exception;
	

	//첨부파일 삭제
	public void fileDelete(int fileDel) throws Exception;
	
}
