package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HellospringController {
	
	@RequestMapping("/hi")
	public String hi() {
		return "/WEB-INF/views/hi.jsp";
	}
}
