package com.bitacademy.helloweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


// 02와 차이; 전부 구현
public class MyInterceptor01 implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor01.preHandle(...) called");
		return true;  // false; controller로 넘어가기 전에 차단
					  // true; postHandle 넘어감
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor01.postHandle(...) called");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor01.afterCompletion(...) called");
	}

}


/*
 * Controller 실행 전 실해되는 interceptor 3단계
 * preHandle, postHandle, afterCompletion
 * 
 * 주로 preHandle 사용함
 */