package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.container.user.User;
import com.bitacademy.container.user.User01;

public class XmlCongfigTest {

	public static void main(String[] args) {
		// XML Auto. Configuration(Annotation Scanning)
		// testApplicationContext01();
		
		// XML Bean Configuration(Explicit Configuration = 수동)
		testApplicationContext02();
	}

	// XML Auto. Configuration(Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext01.xml");
		
		User01 user01 = ac.getBean(User01.class);
		System.out.println(user01.getName());
		
		// Bean의 id가 자동으로 설정된다. (name도 id와 동일한 이름으로 생성됨)
		user01 = (User01)ac.getBean("user01");  // ""로 ID를 줄 수 있지만 캐스팅해야하는 단점
		System.out.println(user01.getName());
	}
	
	// XML Bean Configuration(Explicit Configuration = 수동))
	// User에 @Component 안 붙여도 됨
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext02.xml");
		
		User user = null;
		
		/* id로 빈 가져오기 */
		user = (User) ac.getBean("user");
		System.out.println(user);
		
		/* name으로 빈 가져오기 (잘 사용 안함) */
		user = (User) ac.getBean("usr");
		System.out.println(user);
		
		/* Type으로 빈 가져오기 */
		
		// 1. 같은 타입의 빈이 2개 이상 있을 때 Type으로 빈 가져오기는 실패한다.
		//user = ac.getBean(User.class);
		
		// 2. id + type
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		// 3. name + type
		user = ac.getBean("usr2", User.class);
		System.out.println(user);
		
		/* 2개 파라미터로 생성된 빈 가져오기 1 */
		user = ac.getBean("user3", User.class);
		System.out.println(user);
		
		/* 2개 파라미터로 생성된 빈 가져오기 2 */
		user = ac.getBean("user4", User.class);
		System.out.println(user);
		
		/* setter로 초기화한 빈 가져오기 */
		user = ac.getBean("user5", User.class);
		System.out.println(user);
	}
}
