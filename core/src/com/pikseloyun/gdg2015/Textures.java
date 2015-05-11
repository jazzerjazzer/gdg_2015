package com.pikseloyun.gdg2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textures {

	public Texture mainMenuBackground, gameBackground, buildBackground, 
		mapBackground, soldierBackground, upgradeBackground;
	
	public Texture houseIcon, peopleIcon, scienceIcon, farmIcon;
	
	public Textures(){
		
		mainMenuBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		gameBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		buildBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		mapBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		soldierBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		upgradeBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		
	}
	
	public void loadTextures(){
		
	}
	
}
