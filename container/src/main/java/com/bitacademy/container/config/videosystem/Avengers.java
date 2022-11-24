package com.bitacademy.container.config.videosystem;

import com.bitacademy.container.videosystem.DigitalVideoDisc;

public class Avengers implements DigitalVideoDisc {
	private String studio = "MARVEL";
	private String title = "Avengers";
	
	@Override
	public String play() {
		return "Playing Movie " + studio + "'s " + title;
	}
}
