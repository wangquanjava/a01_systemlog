package com.test.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchVO {
	private String description;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}
