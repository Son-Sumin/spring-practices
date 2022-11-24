package com.bitacademy.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.soundsystem.CDPlayer;

// @ExtendWith; CDPlayerConfigTest는 스프링이 작동되는 클래스임
// @ContextConfiguration(classes= {CDPlayerConfig.class}); 테스트코드에서 테스트용 DI 정보를 어디서 가져와야 하는지 지정
// 스프링이 Junit 관리를 위해 제공하는 어노테이션 

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {CDPlayerConfig.class})
public class CDPlayerConfigTest {
	
	@Autowired
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDPlayerNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlay() {
		String sound = cdPlayer.play();
		assertEquals("Playing 붕붕 by 김하온", sound);
	}
}
