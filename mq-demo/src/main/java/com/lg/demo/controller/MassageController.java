package com.lg.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.demo.service.MsgService;

@Controller
@RequestMapping("/msg")
public class MassageController {
		@Autowired
		private MsgService msgService;
	
		@RequestMapping("/sendQueueMsg")
		@ResponseBody
		public Map<String,Object> sendMsg(String msg){
			msgService.sendQueueMsg(msg);
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("state", 0);
			hashMap.put("data", null);
			return hashMap;
		}
		
		
		@RequestMapping("/receiveQueueMsg")
		@ResponseBody
		public Map<String,Object> receiveMsg(){
			HashMap<String, Object> hashMap = new HashMap<>();
			String receiveMsg=null;
			try {
				receiveMsg = msgService.receiveQueueMsg();
				hashMap.put("state", 0);
			} catch (Exception e) {
				hashMap.put("state", 1);
				e.printStackTrace();
			}
			hashMap.put("data", receiveMsg);
			return hashMap;
		}
		
		@RequestMapping("/sendTopicMsg")
		@ResponseBody
		public Map<String,Object> sendTopicMsg(String msg){
			msgService.sendTopicMsg(msg);
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("state", 0);
			hashMap.put("data", null);
			return hashMap;
		}
		
		
		@RequestMapping("/receiveTopicMsg")
		@ResponseBody
		public Map<String,Object> receiveTopicMsg(){
			HashMap<String, Object> hashMap = new HashMap<>();
			String receiveMsg=null;
			try {
				receiveMsg = msgService.receiveTopicMsg();
				hashMap.put("state", 0);
			} catch (Exception e) {
				hashMap.put("state", 1);
				e.printStackTrace();
			}
			hashMap.put("data", receiveMsg);
			return hashMap;
		}
}
