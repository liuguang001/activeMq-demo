package com.lg.demo.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueListener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		try {
			if (msg instanceof TextMessage) {
				TextMessage textMessage=(TextMessage)msg;
				String text = textMessage.getText();
				System.out.println("接受到消息:"+text);
			}else{
				System.out.println("非文本消息");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
