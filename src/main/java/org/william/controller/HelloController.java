package org.william.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.william.common.AppProperties;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private AppProperties appProperties;
	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String sayHello() {
		System.out.println("testKey:"+appProperties.getTestKey());
		return "hello william !";
	}

}
