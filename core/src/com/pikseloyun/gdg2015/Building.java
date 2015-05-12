package com.pikseloyun.gdg2015;

import utils.CustomProgressBar;

import com.badlogic.gdx.graphics.Texture;

public class Building {

	public int level;
	public int x, y;
	public Texture texture;
	public boolean progress;
	public CustomProgressBar bar;
	public int health;
	public Building(int x, int y, Texture texture){
		level = 1;
		this.x = x;
		this.y = y;
		this.texture = texture;
		health = 5;
	}	
}
