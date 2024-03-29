package com.pikseloyun.gdg2015;

import screens.LoadingScreen;

import com.badlogic.gdx.Game;

public class MainGame extends Game {
	
	public Textures textures;
	public GameState gameState;
	public boolean sound;
	
	@Override
	public void create() {
		sound = true;
		textures = new Textures();
		gameState = new GameState();
		this.setScreen(new LoadingScreen(this));
	}
	
	@Override
	public void render() {		
		super.render();
	}
	
}
