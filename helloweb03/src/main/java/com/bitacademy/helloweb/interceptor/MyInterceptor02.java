package com.bitacademy.helloweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


// 01과 차이; interface에 구현된 필요한 것만 골라쓰기
// 주로 preHandle만 사용하기에 interface 사용이 효율적
public class MyInterceptor02 extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor02.preHandle(...) called");
		return true;
	}
}
// true; concole-메세지 출력 / URL에 맞는 화면 출력
// false; concole-메세지 출력 / URL에 맞는 화면 출력 X