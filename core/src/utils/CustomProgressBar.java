package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/*
 * Sample initialization : 	
 * CustomProgressBar cpb = new CustomProgressBar(Color.BLUE, "empty.png", "empty", 0, 100, 100, 100, 290, 100, 2);	    
 * 
 * */

public class CustomProgressBar {
	
	Stage stage;
	ProgressBar bar;
	Skin skin;
	ProgressBarStyle barStyle;
	TextureRegionDrawable textureBar;
	public CustomProgressBar(Color backgroundColor, String backgroundTextureName, String skinName,
			float min, float max, int positionX, int positionY, int sizeX, int sizeY, int animateDuration){
		
		skin = new Skin();
		stage = new Stage();

		skin.add(skinName, new Texture(backgroundTextureName));

		textureBar = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("full.png"))));
		
		barStyle = new ProgressBarStyle(skin.newDrawable(skinName, Color.DARK_GRAY), textureBar);
		barStyle.knobBefore = barStyle.knob;
		bar = new ProgressBar(min, max, 0.5f, false, barStyle);
		bar.setPosition(positionX, positionY);
		bar.setSize(sizeX, sizeY); // bar.getPrefHeight() for the Y value is preffered. 
		bar.setAnimateDuration(animateDuration);
		stage.addActor(bar);
		Gdx.input.setInputProcessor(stage);
	}

	public void updateProgressBar(float delta, int value){
		bar.setValue(bar.getValue()+value);
		stage.act(delta);
		stage.draw();
	}
}
