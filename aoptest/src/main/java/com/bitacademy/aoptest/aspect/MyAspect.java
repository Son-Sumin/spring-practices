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
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
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

/*
 # Object Oriented Programming
## AOP(Aspect Oriented Programming)
       → 횡단관심을 한 곳에 몰고 필요 시 실행시키자
1. what; advice, 횡단관심  → 어떤 클래스의 메소드
2. when; Joing Point of Advice, 시점
       → 메소드가 실행되는 시점(자바실행을 메소드실행이라 생각하고 메소드에 집중)
            ① before; 메소드 실행 전
            ② after; 메소드 실행 후
            ③ after returning; 메소드가 실행 결과를 얻은 후
            ④ after throwing; 메소드가 실행하다 예외를 던진 후
         ** ⑤ around; 핵심관심 전후(before+after)
3. where; Poing Cut of Advice, which method
       → 어떤 package에 어떤 class의 어떤 method의 이름, 결과 등등
        where 4가지 기준; package, class, method, parameter

<<AOP 방법>>
@Aspect
class {
advisor; method(advice) 중심으로 [예시]@Before(which method)가 있는 class

<<Point Cut 기술방법>>
excution( 접근자 반환타입 패키지.클래스(인터페이스).메소드(인수) ) thorws 예외

1. 접근자 생략가능
2. thorws 예외 생략가능
3. * (와일드 카드) 사용가능
4. 패키지에서의 와일드 카드는 .. 를 사용한다.
5. 메소드의 인수에서 .. 를 사용하면 모든 인수를 의미하게 된다.
6. 패키지명.클래스 명은 생략할 수 있다.

 */
