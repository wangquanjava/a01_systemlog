package com.test.service.impl;

import java.util.Date;
import java.util.List;

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
	private static final int pageSize = 10;
	
	@Override
	public SystemLog findSystemLogById(String id) {
		return this.systemLogMapper.findSystemLogById(id);
	}

	@Override
	public List<SystemLog> findSystemLogListByPage(int page) {
		return this.systemLogMapper.findSystemLogListByPage((page-1)*pageSize, pageSize);
	}

	@Override
	public void deleteSystemLogById(String id) {
		this.systemLogMapper.deleteSystemLogById(id);
	}

	@Override
	public List<SystemLog> findByCriteria(SearchVO searchVO) {
		return this.systemLogMapper.findByCriteria(("%"+searchVO.getDescription()+"%").getBytes(),searchVO.getStartTime(),searchVO.getEndTime());
	}


}
