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
		int prePage = this.currentPage-1;
		int nextPage = this.currentPage+1;
		
		this.pageHtml = "<tr><td>";
		
		if (this.currentPage-1 > 0) {
			this.pageHtml += "<a href='javascript:void(0)' type='"+this.type+"' page='"+prePage+"' class='switchPage'>上一页</a>";
		}else{
			this.pageHtml += "<a href='javascript:void(0)' type='"+this.type+"' page='"+prePage+"' class='switchPage_no'>上一页</a>";
		}
		
		this.pageHtml += this.currentPage+"/"+this.totalPage+" 共"+this.totalIndex+"条";
		
		if (this.currentPage+1 <= this.totalPage) {
			this.pageHtml += "<a href='javascript:void(0)' type='"+this.type+"' page='"+nextPage+"' class='switchPage'>下一页</a>";
		}else{
			this.pageHtml += "<a href='javascript:void(0)' type='"+this.type+"' page='"+nextPage+"' class='switchPage_no'>下一页</a>";
		}
		
		this.pageHtml += "</td></tr>";
		
		return this.pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	
	
}
