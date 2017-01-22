package org.william.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.william.model.Student;
import org.william.util.LoggerUtil;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/message")
public class SendMessageController {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value = "/sendMsg", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public void sendMessage(){
		Student student = new Student();
		student.setName("花崴");
		student.setSex("1");
		LoggerUtil.info(this,"-----------@@@@@@@redis 发送消息 START @@@@@ -----------");
		redisTemplate.convertAndSend("sendStudentMsg", JSONObject.toJSON(student).toString());
		LoggerUtil.info(this,"-----------@@@@@@@redis 发送消息 END @@@@@ -----------");
	}

}
