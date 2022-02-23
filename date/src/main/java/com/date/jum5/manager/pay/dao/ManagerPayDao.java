package com.date.jum5.manager.pay.dao;

import java.util.List;

import com.date.jum5.user.pay.vo.PayStateVo;

public interface ManagerPayDao {

	public abstract List<PayStateVo> payList();
	
	public List<PayStateVo> paySearchList(String searchOption, String keyword) throws Exception;
	
	public int payCountArticle(String searchOption, String kewyword) throws Exception;
}
