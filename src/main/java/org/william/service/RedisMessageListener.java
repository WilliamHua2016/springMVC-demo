package org.william.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.william.model.Student;
import org.william.util.LoggerUtil;

import com.alibaba.fastjson.JSONObject;


public class RedisMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message, byte[] pattern) {
		LoggerUtil.info(this,"-----------@@@@@@@redis接受到消息了@@@@@ -----------");
		String channel = new String(message.getChannel());
        String body = new String(message.getBody());
        LoggerUtil.info(this, String.format("[Redis] received message, topic:%s, message:%s", channel, body));
        Student student = JSONObject.parseObject(body, Student.class);
        LoggerUtil.info(this, String.format("student name : %s", student.getName()));
		
	}

}
