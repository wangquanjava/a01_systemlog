package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.SearchVO;
import com.test.domain.SystemLog;
import com.test.service.SystemLogService;
/*
 * 总结：
 *    1.方法上的@RequestMapping里面，任何时候都是可以加.do也可以不加
 *    2.方法上的@RequestMapping里面,任何时候都是可以加/也可以不加
 */
@Controller
@RequestMapping("systemLogController")
public class SystemLogController {
	@Autowired
	private SystemLogService systemService;
	
	@RequestMapping("/querySystemLogById")
	public ResponseEntity<SystemLog> querySystemLogById(String id){
		SystemLog systemLog = this.systemService.findSystemLogById(id);
		
		return new ResponseEntity<SystemLog>(systemLog, HttpStatus.OK);
	}
	
	
	@RequestMapping("/querySystemLogListByPage")
	public ResponseEntity<List<SystemLog>> querySystemLogListByPage(int page){
		List<SystemLog> systemLogList = this.systemService.findSystemLogListByPage(page);
		
		return new ResponseEntity<List<SystemLog>>(systemLogList, HttpStatus.OK);
	}
	
	
	@RequestMapping("/deleteSystemLogById")
	public ResponseEntity<Void> deleteSystemLogById(String id){
		this.systemService.deleteSystemLogById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping("/findByCriteria")
	public ResponseEntity<List<SystemLog>> findByCriteria(SearchVO searchVO){
		List<SystemLog> systemLogList = this.systemService.findByCriteria(searchVO);
		
		return new ResponseEntity<List<SystemLog>>(systemLogList, HttpStatus.OK);
	}
	
	
}
