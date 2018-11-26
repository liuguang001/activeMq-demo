package com.lg.demo.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService{
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private ActiveMQQueue destinationQueue;
	@Autowired
	private ActiveMQTopic destinationTopic;
	
	
	@Override
	public void sendQueueMsg(final String msg) {
		System.out.println("向"+destinationQueue.toString()+"发送: "+msg);
		jmsTemplate.send(destinationQueue,new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

	@Override
	public String receiveQueueMsg() throws Exception {
		TextMessage message = (TextMessage)jmsTemplate.receive(destinationQueue);
		String text = message.getText();
		System.out.println("收到消息: "+text);
		return text;
	}
	
	@Override
	public void sendTopicMsg(final String msg) {
		System.out.println("向"+destinationTopic.toString()+"发送: "+msg);
		jmsTemplate.send(destinationTopic,new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
	
	@Override
	public String receiveTopicMsg() throws Exception {
		TextMessage message = (TextMessage)jmsTemplate.receive(destinationTopic);
		String text = message.getText();
		System.out.println("收到消息: "+text);
		return text;
	}
	
}
