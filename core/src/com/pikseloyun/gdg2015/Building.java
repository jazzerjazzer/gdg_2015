package com.pikseloyun.gdg2015;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Building {

	public int level;
	public int x, y;
	public Texture texture;
	public Building(int x, int y, Texture texture ){
		level = 1;
		this.x = x;
		this.y = y;
		this.texture = texture;
	}
	
	public void draw(SpriteBatch batch){
		if(y > 285){
			y-=5;
		}
		batch.draw(texture, x, y);
	}
}
