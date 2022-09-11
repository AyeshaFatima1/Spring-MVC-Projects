package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {
	@RequestMapping(value="/helloworld",method=RequestMethod.GET)
	public String helloWorld() {
		return "index";
	}
	@RequestMapping(value="/first",method=RequestMethod.GET)
	public String helloWorld1() {
		return "first";
	}
}
