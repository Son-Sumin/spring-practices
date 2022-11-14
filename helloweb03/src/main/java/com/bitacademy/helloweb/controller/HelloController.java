package com.bitacademy.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")  // /hello 이런 요청이 오면 아래를 실행시켜라
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
}
