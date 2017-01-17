package org.william.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.william.common.AppProperties;
import org.william.util.redis.RedisCacheStore;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private RedisCacheStore redisCacheStore;
	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String sayHello() {
		System.out.println("get testKey from property:"+appProperties.getTestKey());
		redisCacheStore.save("testKey", appProperties.getTestKey());
		System.out.println("get testKey from redis:"+redisCacheStore.get("testKey"));
		return "hello william !";
	}

}
