package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bitacademy.container.config.user.AppConfig01;
import com.bitacademy.container.user.User;
import com.bitacademy.container.user.User01;

public class AppConfigTest {

	public static void main(String[] args) {
		testAppConfig01();
		testAppConfig02();
	}

	// Java AppCongif 01
	// 직접 자바 클래스(Config Class)를 전달
	private static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user = ac.getBean(User.class);
		System.out.println("testAppConfig01: " + user);
	}
	
	// Java AppCongif 02
	// 자바 클래스(Config Class)가 있는 패키지를 전달
	// AppConfig01와 02 메소드 이름이 같지 않게 주의
	private static void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.bitacademy.container.config.user");
		
		User user = ac.getBean(User.class);
		System.out.println("testAppConfig02: " + user);
		
		User01 user01 = ac.getBean(User01.class);
		System.out.println("testAppConfig02: " + user01.getName());
	}

}
