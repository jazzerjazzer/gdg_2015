package Buildings;

import utils.Animator;

import com.badlogic.gdx.graphics.Texture;
import com.pikseloyun.gdg2015.Building;

public class Barracks extends Building {
	public Animator a;
	public boolean isFighting = false;
	public Barracks(int x, int y, Texture texture, Animator a){
	
		super(x, y, texture);
		this.a = a;
	}
}
