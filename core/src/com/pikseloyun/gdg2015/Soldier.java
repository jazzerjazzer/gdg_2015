package com.pikseloyun.gdg2015;

import com.badlogic.gdx.graphics.Texture;

public class Soldier {
	
	public int id, x= 100, y = 300;
	public Texture texture;
	public Soldier(int id, Texture texture){
		this.id=id;
		this.texture = texture;
	}
}
