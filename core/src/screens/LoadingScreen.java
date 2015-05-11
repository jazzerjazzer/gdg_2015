package screens;

import utils.CustomProgressBar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.pikseloyun.gdg2015.MainGame;

public class LoadingScreen implements Screen {

	MainGame game;
	public OrthographicCamera camera;
	public SpriteBatch batch;
	private Texture background;
	private boolean everythingLoaded = false;
	private boolean splash = true, bgLoaded = false, rendered = false;

	public LoadingScreen(MainGame mainGame) {
		game = mainGame;
	}

	@Override
	public void show() {
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		batch.setProjectionMatrix(camera.combined);
		
		background = new Texture(Gdx.files.internal("menus/loadingScreen.jpg"));
		bgLoaded = true;
	}

	@Override
	public void render(float delta) {

		if (!rendered){
			rendered = true;
		} else {
			if(splash && bgLoaded){
				loadTextures();
			}

			if (everythingLoaded) { 
				game.setScreen(new MainMenuScreen(game));
			}
		}

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background,0,0);

		batch.end();
	}

	public void loadTextures(){

		game.textures.loadTextures();

		splash = false;
		everythingLoaded = true;

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
