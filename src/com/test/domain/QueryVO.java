package com.test.domain;

import java.util.List;

public class QueryVO {
	private List<SystemLog> systemLogList;
	private int currentPage;
	private int totalPage;
	private int totalIndex;
	//1_查询，2_搜索
	private int type;
	private String pageHtml;
	
	
	public List<SystemLog> getSystemLogList() {
		return systemLogList;
	}
	public void setSystemLogList(List<SystemLog> systemLogList) {
		this.systemLogList = systemLogList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalIndex() {
		return totalIndex;
	}
	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	
	
}
