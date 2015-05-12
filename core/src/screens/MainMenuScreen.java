package screens;

import utils.CustomProgressBar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.pikseloyun.gdg2015.MainGame;

public class MainMenuScreen implements Screen {

	MainGame game;
	Texture background;
	
	public OrthographicCamera camera;
	public SpriteBatch batch;
	private Vector3 tap = new Vector3(0,0,0);
	private CustomProgressBar bar;
	
    private Texture fontTexture;
    private BitmapFont font;
	
	public MainMenuScreen(MainGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		
		batch = new SpriteBatch();
		background = game.textures.mainMenuBackground;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		
		fontTexture = new Texture(Gdx.files.internal("font.png"));
		font = new BitmapFont(Gdx.files.internal("font.fnt"), new TextureRegion(fontTexture), false);
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			batch.draw(background,0,0);
			if(game.sound)
				batch.draw(game.textures.soundOn, 10, 950);
			else
				batch.draw(game.textures.soundOff, 10, 950);
		batch.end();
		
		if(Gdx.input.justTouched()){
			
			tap.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(tap);
			
			int x = (int) tap.x;
			int y = (int) tap.y;
			
			if(x < 1750 && x > 1570 && y < 920 && y > 850){
				game.setScreen(new GameScreen(game));
			} 
			if(x < 1750 && x > 1570 && y < 480 && y > 435){
				System.exit(0);
			}
			if(x < 130 && x > 10 && y < 1080 && y > 950){
				game.sound = !game.sound;
			}

		}
		
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
