package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ProductService;
import vo.ProductVo;

public class MainAop {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml"); // ClassPath: 기본이어서 안 붙여도 됨
		
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
	}

}