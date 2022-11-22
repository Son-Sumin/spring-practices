package com.bitacademy.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping("/upload")
	public String upload(
			@RequestParam("email") String email,
			@RequestParam("file") MultipartFile multipartFile,
			Model model) {
		System.out.println("email:" + email);
		
		String url = fileUploadService.restore(multipartFile);  // 반드시 url 안 만들어도 됨(비지니스마다 상이)
		model.addAttribute("url", url);
		
		return "/WEB-INF/views/result.jsp";
	}
}
