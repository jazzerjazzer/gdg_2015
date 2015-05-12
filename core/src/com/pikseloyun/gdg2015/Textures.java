package com.pikseloyun.gdg2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textures {

	public Texture mainMenuBackground, gameBackground, mapBackground;
	public Texture warCard, magicCard, buildCard;
	
	public Texture smallHouse, middleHouse, bigHouse;
	public Texture smallMagic, middleMagic, bigMagic;
	public Texture smallMilitary, middleMilitary, bigMilitary;
	
	public Texture pumpkin, pumpkin2, pumpkin3, lamp, sign;
	public Texture soldier;
	
	public Textures(){

	}
	
	public void loadTextures(){
		
		mainMenuBackground = new Texture(Gdx.files.internal("menus/mainMenuScreen.jpg"));
		gameBackground = new Texture(Gdx.files.internal("menus/gameScreen.png"));
		mapBackground = new Texture(Gdx.files.internal("menus/mapScreen.jpg"));
		
		warCard = new Texture(Gdx.files.internal("icons/warCard.png"));
		magicCard = new Texture(Gdx.files.internal("icons/magicCard.png"));
		buildCard = new Texture(Gdx.files.internal("icons/buildCard.png"));
		
		smallHouse = new Texture(Gdx.files.internal("buildings/smallHouse.png"));
		middleHouse = new Texture(Gdx.files.internal("buildings/middleHouse.png"));
		bigHouse = new Texture(Gdx.files.internal("buildings/bigHouse.png"));
		
		smallMagic = new Texture(Gdx.files.internal("buildings/smallMagic.png"));
		middleMagic = new Texture(Gdx.files.internal("buildings/middleMagic.png"));
		bigMagic = new Texture(Gdx.files.internal("buildings/bigMagic.png"));
		
		smallMilitary = new Texture(Gdx.files.internal("buildings/smallMilitary.png"));
		middleMilitary = new Texture(Gdx.files.internal("buildings/middleMilitary.png"));
		bigMilitary = new Texture(Gdx.files.internal("buildings/bigMilitary.png"));
		
		pumpkin = new Texture(Gdx.files.internal("buildings/pumpkin.png"));
		pumpkin2 = new Texture(Gdx.files.internal("buildings/pumpkin2.png"));
		pumpkin3 = new Texture(Gdx.files.internal("buildings/pumpkin3.png"));
		lamp = new Texture(Gdx.files.internal("buildings/lamp.png"));
		sign = new Texture(Gdx.files.internal("buildings/sign.png"));
		
		soldier = new Texture(Gdx.files.internal("soldier-icon.png"));
		
	}
	
}
