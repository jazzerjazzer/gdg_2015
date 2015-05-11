package com.pikseloyun.gdg2015.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pikseloyun.gdg2015.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "GDG2015";
		cfg.width = 1920;
		cfg.height = 1080;
		
		new LwjglApplication(new MainGame(), cfg);
		
	}
}
