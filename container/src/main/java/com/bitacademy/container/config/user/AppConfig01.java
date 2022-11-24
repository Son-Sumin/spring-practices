package com.bitacademy.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.container.user.User;

// 생성은 되지만 DI가 안되니 @ 달기
@Configuration
public class AppConfig01 {
	
	@Bean
	public User user() {
		return new User();
	}
}
