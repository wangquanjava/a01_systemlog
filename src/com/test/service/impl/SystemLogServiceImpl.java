package com.test.service.impl;

import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.SearchVO;
import com.test.domain.SystemLog;
import com.test.mapper.SystemLogMapper;
import com.test.service.SystemLogService;
@Service
public class SystemLogServiceImpl implements SystemLogService {
	@Autowired
	private SystemLogMapper systemLogMapper;
	private static final int pageSize = Integer.parseInt(ResourceBundle.getBundle("env").getString("pageSize"));
	
	@Override
	public SystemLog findSystemLogById(String id) {
		return this.systemLogMapper.findSystemLogById(id);
	}

	@Override
	public List<SystemLog> findSystemLogListByPage(int page) {
		return this.systemLogMapper.findSystemLogListByPage((page-1)*pageSize, pageSize);
	}
	
	@Override
	public int findTotalIndex() {
		return this.systemLogMapper.findTotalIndex();
	}
	@Override
	public void deleteSystemLogById(String id) {
		this.systemLogMapper.deleteSystemLogById(id);
	}

	@Override
	public List<SystemLog> findByCriteria(SearchVO searchVO) {
		return this.systemLogMapper.findByCriteria(searchVO.getDescription().getBytes(),searchVO.getStartTime(),searchVO.getEndTime(),(searchVO.getPage()-1)*pageSize,pageSize);
	}

	@Override
	public int findTotalIndexByCriteria(SearchVO searchVO) {
		return this.systemLogMapper.findTotalIndexByCriteria(searchVO.getDescription().getBytes(),searchVO.getStartTime(),searchVO.getEndTime());
	}



}
