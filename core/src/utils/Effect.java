package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Effect {
	
	Sound sound;

	public Effect(String fileName){
		sound = Gdx.audio.newSound(Gdx.files.internal(fileName));
	}
	
	public void playEffect(){
		sound.play(1.0f);
	}
}
