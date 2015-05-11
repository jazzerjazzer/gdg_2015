package com.pikseloyun.gdg2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textures {

	public Texture mainMenuBackground, gameBackground, buildBackground, 
		mapBackground, soldierBackground, upgradeBackground, background0;
	
	public Texture houseIcon, peopleIcon, scienceIcon, farmIcon;
	public Texture warCard, magicCard, buildCard, logo;

	
	public Textures(){
		
		mainMenuBackground = new Texture(Gdx.files.internal("menus/mainMenuScreen.jpg"));
		gameBackground = new Texture(Gdx.files.internal("menus/gameScreen.png"));
		mapBackground = new Texture(Gdx.files.internal("menus/mapScreen.jpg"));
		background0 = new Texture(Gdx.files.internal("menus/background0.png"));
		
		warCard = new Texture(Gdx.files.internal("icons/warCard.png"));
		magicCard = new Texture(Gdx.files.internal("icons/magicCard.png"));
		buildCard = new Texture(Gdx.files.internal("icons/buildCard.png"));
		logo = new Texture(Gdx.files.internal("icons/upgrade_icon.png"));
		
		buildBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		soldierBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		upgradeBackground = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		
	}
	
	public void loadTextures(){
		
	}
	
}
