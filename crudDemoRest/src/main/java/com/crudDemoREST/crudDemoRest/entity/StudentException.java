package com.crudDemoREST.crudDemoRest.entity;

public class StudentException {
	private int id;
	private String msg;
	private long timeStamp;
	public StudentException() {
		super();
	}
	public StudentException(int id, String msg, long timeStamp) {
		super();
		this.id = id;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
