package com.bitacademy.helloweb.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")  // /hello 이런 요청이 오면 아래를 실행시켜라
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")  // Long.parselong 하지 않아도 알아서 해줌~
	public String hello2(String name, Long no) {
		System.out.println("name: " + name + ", no: " + no);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
	@RequestMapping("/hello4")  // 추추천천
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello4.jsp";
	}
	
	@ResponseBody  // 이것이 있으면 아래로 인식, 없으면 위로 인식, 객체를 받아 API 사용시 주로 사용
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>Hello World</h1>";
	}
	
	@RequestMapping("/hello6")  // 내가 준 URL만 사용하면 됨 (/helloweb03/hello6 아니라)
	public String hello6() {
		return "redirect:/hello";
	}
	
	@RequestMapping("/hello7")  // 비추, 보여주는 수업용
	public void hello6(
		HttpServletRequest request,
		HttpServletResponse response,
		Writer out) throws IOException {
		
		String name = request.getParameter("name");
		// response.getWriter().println("hello " + name);  // Writer out과 아래줄 제거
		out.write("hello " + name);
	}
}


/* 흔히 실수하는 부분

1. HelloController.java -> not import @Controller
2. Dispatcher Servlet 관련 WEB-INF/spring(서블릿 이름)-servlet.xml 만들기
3. spring-servlet.xml -> base-package="com.bitacademy.helloweb.controller" 오타


<<순서>>
helloweb03/pom.xml; properties, dependencies, build 추가 및 확인

-> Java EE Tools - generate Descripter 후 helloweb03/WEB-INF/web.xml; Dispatcher Servlet 설정

-> helloweb03/WEB-INF/spring-servlet.xml 생성 후 base-package 설정(오타 주의)
	base-package에서 설정한 파일 이하로 탐색하기 때문에 세부적으로 설정하는 것이 좋음
	
-> com.bitacademy.helloweb.controller 패키지 생성, HelloController.java 생성

-> HelloController.java에서 @Controller, @RequestMapping("/hello") 주의하여 작성

-> /WEB-INF/views/hello.jsp 생성 ()

*/