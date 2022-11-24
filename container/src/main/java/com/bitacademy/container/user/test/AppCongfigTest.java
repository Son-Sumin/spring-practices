package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bitacademy.container.config.user.AppConfig01;
import com.bitacademy.container.user.User;

public class AppCongfigTest {

	public static void main(String[] args) {
		testAppConfig01();
	}

	// Java Congif 01
	// 직접 자바 클래스(Config Class)를 전달
	private static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user = ac.getBean(User.class);
		System.out.println(user);
	}

}
