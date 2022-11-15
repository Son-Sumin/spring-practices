package com.bitacademy.emaillist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.emaillist.repository.EmaillistRepository;

@Controller
public class EmaillistController {
	@Autowired  // Root EmailRepo -> Web EmailRepo 자동 DI!!
	private EmaillistRepository emaillistRepository;
	
	@ResponseBody  // test 위해 나에게 받기
	@RequestMapping("")
	public String index() {
		return "index!!";
	}
}
