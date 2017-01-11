package org.william.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String sayHello() {
		return "hello william !";
	}

}
