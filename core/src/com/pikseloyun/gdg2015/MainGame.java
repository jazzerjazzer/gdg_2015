package com.pikseloyun.gdg2015;

import screens.LoadingScreen;
import com.badlogic.gdx.Game;

public class MainGame extends Game {
	
	public Textures textures;

	@Override
	public void create() {
		textures = new Textures();
		this.setScreen(new LoadingScreen(this));
	}
	
	@Override
	public void render() {		
		super.render();
	}
	
}
