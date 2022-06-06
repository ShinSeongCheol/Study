package com.wrox;

import java.io.Serializable;
import java.net.InetAddress;

public class PageVisit implements Serializable{
	private long enteredTimestamp;
	
	private Long leftTimestamp;
	
	private String request;
	
	private InetAddress ipAddress;
	
	public void setEnteredTimestamp(long enteredTimestamp) {
		this.enteredTimestamp = enteredTimestamp;
	}
	
	public long getEnteredTimestamp() {
		return this.enteredTimestamp;
	}
	
	public void setLeftTimestamp(Long leftTimestamp) {
		this.leftTimestamp = leftTimestamp;
	}
	
	public Long getLeftTimestamp() {
		return this.leftTimestamp;
	}
	
	public void setRequest(String request) {
		this.request = request;
	}
	
	public String getRequest() {
		return this.request;
	}
	
	public void setIpAddress(InetAddress ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public InetAddress getIpAddress() {
		return this.ipAddress;
	}
}
