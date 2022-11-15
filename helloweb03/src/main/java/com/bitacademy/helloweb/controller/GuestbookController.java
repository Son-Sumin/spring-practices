package com.bitacademy.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping 클래스 단독 매핑
 */

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping   // 핸들러라는 표시, 매핑은 클래스!!
	public String list() {
		return "GuestbookController.list()";
	}
	
	@ResponseBody
	@RequestMapping   // 핸들러라는 표시, 매핑은 클래스!!
	public String delete() {
		return "GuestbookController.delete()";
	}
}
