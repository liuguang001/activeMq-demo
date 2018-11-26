package com.lg.demo.service;

public interface MsgService {
	public void sendQueueMsg(String msg);
	public String receiveQueueMsg()throws Exception;
	String receiveTopicMsg() throws Exception;
	void sendTopicMsg(String msg);
}
