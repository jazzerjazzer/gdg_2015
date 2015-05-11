package com.pikseloyun.gdg2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textures {

	public Texture mainMenuBackground, gameBackground, buildBackground, 
		mapBackground, soldierBackground, upgradeBackground;
	
	public Texture houseIcon, peopleIcon, scienceIcon, farmIcon;
	public Texture warCard, magicCard, buildCard, logo;

	
	public Textures(){
		
		mainMenuBackground = new Texture(Gdx.files.internal("menus/mainMenuScreen.jpg"));
		gameBackground = new Texture(Gdx.files.internal("menus/gameScreen.jpg"));
		mapBackground = new Texture(Gdx.files.internal("menus/mapScreen.jpg"));
		
		warCard = new Texture(Gdx.files.internal("icons/mainMenuScreen.png"));
		magicCard = new Texture(Gdx.files.internal("icons/gameScreen.png"));
		buildCard = new Texture(Gdx.files.internal("icons/mapScreen.png"));
		logo = new Texture(Gdx.files.internal("icons/upgrade_icon.png"));
		
		buildBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		soldierBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		upgradeBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		
	}
	
	public void loadTextures(){
		
	}
	
}
