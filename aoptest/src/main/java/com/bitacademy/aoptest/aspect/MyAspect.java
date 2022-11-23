package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	  		// public 생략 가능, 리턴타입, 패키지.클래스.메소드(파라미터 타입)
	@Before("execution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("--- Before Advice ---");
	}
	
	@After("execution(* *..*.ProductService.find(..))")  // *[접근자] *..*[package].*[class].*[method](..[파라미터 타입])
	public void afterAdvice() {
		System.out.println("--- After Advice ---");
	}
	
	@AfterReturning("execution(* *..*.ProductService.*(..))")  // ProductService의 모든 메소드
	public void afterReturningAdvice() {
		System.out.println("--- After Returning Advice ---");
	}
	
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")  
	public void afterThrowingAdvice(Throwable ex) {				// 모든 Exception은 Throwable interface을 구현함
		System.out.println("--- After Throwing Advice:" + ex+ "---");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		/* before */
		System.out.println("--- Around(Before) Advice ---");
		
		/* PointCut Method 실행 */
		Object result = pjp.proceed();
		
		// 파라미터 가로채기
		// 기존에 추가하거나 test할 때
		// Object[] params = {"Camera"};  // 파라미터가 여러 개일 수도 있으니 배열 Object[]
		// Object result = pjp.proceed(params);
		
		/* after */
		System.out.println("--- Around(After) Advice ---");
		
		return result;
	}
	
}
