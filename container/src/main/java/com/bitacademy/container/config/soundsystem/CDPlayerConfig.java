package com.bitacademy.container.config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.bitacademy.container.soundsystem"})
public class CDPlayerConfig {

}

// 메소드에 @Bean사용, 클래스에 @Component 사용, @Bean과 @Component가 붙여주면 스프링이 빈을 생성해줌
// Bean은 @Configuration과 같이 사용해야함. 
// 클래스에 @Configuration 사용하면 싱글톤을 보장해주고, 해당 클래스에서 빈을 생성하겠다는 것을 스프링이 알고 해줌.
// 스프링은 @Component Scan을 사용해 @Component 있는 클래스들을 찾아서 자동으로 빈 등록을 해줌. 
