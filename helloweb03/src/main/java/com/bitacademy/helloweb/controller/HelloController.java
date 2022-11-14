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


/* 흔히 실수하는 부분

1. public class HelloController; not import @Controller

2. Dispatcher Servlet 관련 WEB-INF/spring(서블릿 이름)-servlet.xml 만들기

3. spring-servlet.xml; base-package="com.bitacademy.helloweb.controller" 오타


<<순서>>
helloweb03/pom.xml; properties, dependencies, build 추가 및 확인
-> helloweb03/WEB-INF/web.xml; Dispatcher Servlet 설정
-> helloweb03/WEB-INF/spring-servlet.xml 생성 후 base-package 설정(오타 주의)
-> com.bitacademy.helloweb.controller 패키지 생성, HelloController.java 생성
-> HelloController.java에서 @Controller, @RequestMapping("/hello") 주의하여 작성
-> /WEB-INF/views/hello.jsp 생성 ()

*/