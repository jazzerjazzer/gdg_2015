package com.pikseloyun.gdg2015;

import utils.Animator;

import com.badlogic.gdx.graphics.Texture;

public class Soldier {
	
	public int id, x, y = 300;
	public Texture texture;
	public Animator anim;
	public int health;
	public String status="walking";
	public Soldier(int id, Texture texture, int x, Animator anim, int health){
		this.x = x;
		this.id=id;
		this.texture = texture;
		this.anim = anim;
		this.health = health;
	}
}
