package com.date.jum5.manager.login.mapper;

import org.springframework.stereotype.Service;

import com.date.jum5.manager.login.vo.ManagerLoginVo;

@Service
public interface ManagerLoginService {
	
	public String checkId(String id) throws Exception;

	public int idExist(String id);
}
