package com.bitacademy.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 추천!
 * @RequestMapping 클래스 + 메소드
 * 같은 URL, 다른 메소드 
 * 
 * 변수이름은 상세히, 파라미터는 보여지는 의미 없게
 * 
 * 기본값 세팅, 400으로 가지 않도록!
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";  // forward
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";  // redirect
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {  // "n"; 변수 이름 같아도 써주기, 다르면 꼭 쓰기
		/*
		 * 만일 n이라는 이름의 URL 파라미터가 없는 경우
		 * 400(Bad Request) 에러가 발생한다.
		 */
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=true, defaultValue="") String name) {
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/list")  // int여도 값 지정은 "1", int로 나옴
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) { 
		return "UserController.list(" + pageNo + ")";
	}
}
