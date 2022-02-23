package com.date.jum5.manager.pay.mapper;

import java.util.List;

import com.date.jum5.user.pay.vo.PayStateVo;

public interface ManagerPayService {

	public abstract List<PayStateVo> payList();
	
	public List<PayStateVo> paySearchList(String searchOption, String keyword) throws Exception;
	
	public int payCountArticle(String searchOption, String keyword) throws Exception;
}
