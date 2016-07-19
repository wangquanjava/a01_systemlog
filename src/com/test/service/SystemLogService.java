package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.domain.SearchVO;
import com.test.domain.SystemLog;

public interface SystemLogService {
	public SystemLog findSystemLogById(String id);
	public List<SystemLog> findSystemLogListByPage(int page);
	public void deleteSystemLogById(String id);
	public List<SystemLog> findByCriteria(SearchVO searchVO);
}
