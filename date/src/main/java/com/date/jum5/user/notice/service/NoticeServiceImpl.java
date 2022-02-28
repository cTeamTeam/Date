package com.date.jum5.user.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.date.jum5.user.notice.dao.NoticeDao;
import com.date.jum5.user.notice.util.NoticeUtil;
import com.date.jum5.user.notice.vo.NoticeVo;
import com.date.jum5.user.review.vo.SearchCriteria;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Resource(name="NoticeUtil")
	private NoticeUtil noticeUtil;
	
	@Inject
	private NoticeDao dao;
	
	// 공지사항 작성
	@Override
	public void write(NoticeVo vo, MultipartHttpServletRequest mpRequest) throws Exception {
		
		vo.setBno(dao.getMaxBno() + 1);
		
		dao.write(vo);
		
		List<Map<String,Object>> list = noticeUtil.parselnsertFileInfo(vo, mpRequest);
		
		Map<String, Object> tempMap = null;
		int size = list.size();
		
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				dao.insertFile(tempMap);
			}else {
				dao.updateFile(tempMap);
			}
		}
	}
	
	//공지사항 목록조회
	@Override
	public List<NoticeVo> noticeList(SearchCriteria scri) throws Exception {
		return dao.noticeList(scri);
	}
	
	//게시글 총 갯수
	@Override
	public int noticeCount(SearchCriteria scri) throws Exception {
		return dao.noticeCount(scri);
	}
	//공지사항 상세 조회
	@Override
	public NoticeVo read(int bno) throws Exception {
		return dao.read(bno);
	}
	//공지사항 수정
	@Override
	public void noticeUpdate(NoticeVo vo, MultipartHttpServletRequest mpRequest) throws Exception {
		
		dao.noticeUpdate(vo);
		
		List<Map<String,Object>> list = noticeUtil.parselnsertFileInfo(vo, mpRequest);
		
		Map<String, Object> tempMap = null;
		int size = list.size();
		
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				dao.insertFile(tempMap);
			}else {
				dao.updateFile(tempMap);
			}
		}
	}
	// 공지사항 삭제
	@Override
	public int noticeDelete(int parseInt) {
		return dao.noticeDelete(parseInt);
	}
	//첨부파일 조회
	@Override
	public List<Map<String , Object>> selectFileList(int bno) throws Exception {
		return dao.selectFileList(bno);
	}
		
	//첨부파일 다운로드
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return dao.selectFileInfo(map);
	}
	
	//파일 삭제
	@Override
	public void fileDelete(int fileDel) throws Exception {
		dao.fileDelete(fileDel);
	}
	
	
}
