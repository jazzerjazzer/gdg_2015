package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.pikseloyun.gdg2015.MainGame;

public class GameScreen implements Screen, GestureListener {

	MainGame game;
	Texture background;
	
	OrthographicCamera camera;
	SpriteBatch batch;
	private Vector3 tap = new Vector3(0,0,0);
	
	private Texture fontTexture;
    private BitmapFont font;
    private GestureDetector gd;
    int panX = 0;
	public GameScreen(MainGame game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		
		batch = new SpriteBatch();
		background = game.textures.gameBackground;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		
		fontTexture = new Texture(Gdx.files.internal("font.png"));
		font = new BitmapFont(Gdx.files.internal("font.fnt"), new TextureRegion(fontTexture), false);
		font.setColor(Color.WHITE);
		gd = new GestureDetector(this);
		Gdx.input.setInputProcessor(gd);
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			batch.draw(background,panX,0);
			batch.draw(game.textures.magicCard,0,0);
			batch.draw(game.textures.warCard,182,0);
			batch.draw(game.textures.buildCard,364,0);
			font.draw(batch, "Gold : "+game.gameState.gold, 300, 1050);
			font.draw(batch, "Population : "+game.gameState.population, 700, 1050);
			font.draw(batch, "Magic : "+game.gameState.magic, 1200, 1050);

		batch.end();
		
		if(Gdx.input.justTouched()){
			
			tap.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(tap);
			
			int x = (int) tap.x;
			int y = (int) tap.y;
			
			// Touched magic card
			if(x < 180 && x > 0 && y < 280 && y > 0){
				//game.setScreen(new MapScreen(game));
			}
			// Touched war card
			if(x < 364 && x > 181 && y < 280 && y > 0){
				//game.setScreen(new MapScreen(game));
			}
			// Touched build card
			if(x < 545 && x > 365 && y < 280 && y > 0){
				//game.setScreen(new MapScreen(game));
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
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		panX += (int)deltaX;
		if(panX > 0)
			panX = 0;
		if (panX < 1920 - 8000)
			panX = 1920-8000;
		System.out.println(panX);
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}


}
