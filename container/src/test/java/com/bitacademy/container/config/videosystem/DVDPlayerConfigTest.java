package com.bitacademy.container.config.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.videosystem.DVDPlayer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerConfigTest {
	
	// 같은 타입의 Bean이 2개 이상 있는 경우
	// 설정 클래스의 빈 생성 메소드 이름을 지정
	@Autowired
	@Qualifier("dvdPlayer1")
	private DVDPlayer dvdPlayer1;
	
	// 같은 타입의 Bean의 2개 이상 있는 경우
	// 설정 클래스의 빈 생성 메소드의 @Bean의 name 속성의 값을 사용
	@Autowired
	@Qualifier("dvdPlayerTwo")
	private DVDPlayer dvdPlayer2;
	
	@Autowired
	@Qualifier("dvdPlayer3")
	private DVDPlayer dvdPlayer3;
	
	@Test
	public void testDVDPlayerNotNull() {
		assertNotNull(dvdPlayer1);
		assertNotNull(dvdPlayer2);
		assertNotNull(dvdPlayer3);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer1.play());
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer2.play());
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer3.play());
	}

}
