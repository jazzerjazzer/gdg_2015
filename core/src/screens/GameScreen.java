package screens;

import utils.Animator;
import utils.CustomProgressBar;
import Buildings.Barracks;
import Buildings.Crypt;
import Buildings.House;

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
import com.pikseloyun.gdg2015.Soldier;

public class GameScreen implements Screen, GestureListener {

	MainGame game;
	Texture background, backgroundUp;

	OrthographicCamera camera;
	SpriteBatch batch;
	private Vector3 tap = new Vector3(0,0,0);

	private Texture fontTexture;
	private BitmapFont font;
	private GestureDetector gd;
	int panX = 0;

	Animator skeletonAnimator, soldierAttackLeftAnim, soldierAttackRightAnim;
	TextureRegion[] skeletonRegion;
	TextureRegion[] soldierWalkLeft, soldierWalkRight;
	Animator soldierWalkLeftAnim, soldierWalkRightAnim;

	int placing = -1;
	long startTime, gameStart = 0;
	int soldierId = 0;
	int counter = 0;
	int level1=10, level2=10, level3=10;
	TextureRegion[]	soldierAttackLeft;   
	TextureRegion[] soldierAttackRight; 

	boolean builtFirstBuilding = false;


	boolean level1Over=false, level2Over=false, level3Over=false;
	public GameScreen(MainGame game) {
		this.game = game;
	}

	@Override
	public void show() {

		batch = new SpriteBatch();
		background = game.textures.gameBackground;
		backgroundUp = game.textures.background1;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);

		fontTexture = new Texture(Gdx.files.internal("font.png"));
		font = new BitmapFont(Gdx.files.internal("font.fnt"), new TextureRegion(fontTexture), false);
		font.setColor(Color.WHITE);

		gd = new GestureDetector(this);
		Gdx.input.setInputProcessor(gd);

		skeletonAnimator = new Animator();
		soldierAttackLeftAnim = new Animator();
		soldierAttackRightAnim = new Animator();

		TextureRegion[]     walkFrames;        
		walkFrames = new TextureRegion[5];
		walkFrames[0] = new TextureRegion(new Texture("animations/skeleton_animation/s1.png"));
		walkFrames[1] = new TextureRegion(new Texture("animations/skeleton_animation/s2.png"));
		walkFrames[2] = new TextureRegion(new Texture("animations/skeleton_animation/s3.png"));
		walkFrames[3] = new TextureRegion(new Texture("animations/skeleton_animation/s4.png"));
		walkFrames[4] = new TextureRegion(new Texture("animations/skeleton_animation/s5.png"));

		soldierAttackLeft = new TextureRegion[6];
		soldierAttackLeft[0] = new TextureRegion(new Texture("animations/soldier_animation/a1.png"));
		soldierAttackLeft[1] = new TextureRegion(new Texture("animations/soldier_animation/a2.png"));
		soldierAttackLeft[2] = new TextureRegion(new Texture("animations/soldier_animation/a3.png"));
		soldierAttackLeft[3] = new TextureRegion(new Texture("animations/soldier_animation/a4.png"));
		soldierAttackLeft[4] = new TextureRegion(new Texture("animations/soldier_animation/a5.png"));
		soldierAttackLeft[5] = new TextureRegion(new Texture("animations/soldier_animation/a6.png"));


		soldierAttackRight = new TextureRegion[6];
		soldierAttackRight[0] = new TextureRegion(new Texture("animations/soldier_animation/b1.png"));
		soldierAttackRight[1] = new TextureRegion(new Texture("animations/soldier_animation/b2.png"));
		soldierAttackRight[2] = new TextureRegion(new Texture("animations/soldier_animation/b3.png"));
		soldierAttackRight[3] = new TextureRegion(new Texture("animations/soldier_animation/b4.png"));
		soldierAttackRight[4] = new TextureRegion(new Texture("animations/soldier_animation/b5.png"));
		soldierAttackRight[5] = new TextureRegion(new Texture("animations/soldier_animation/b6.png"));

		soldierWalkLeft = new TextureRegion[9];
		soldierWalkLeft[0] = new TextureRegion(new Texture("animations/soldier_animation/c1.png"));
		soldierWalkLeft[1] = new TextureRegion(new Texture("animations/soldier_animation/c2.png"));
		soldierWalkLeft[2] = new TextureRegion(new Texture("animations/soldier_animation/c3.png"));
		soldierWalkLeft[3] = new TextureRegion(new Texture("animations/soldier_animation/c4.png"));
		soldierWalkLeft[4] = new TextureRegion(new Texture("animations/soldier_animation/c5.png"));
		soldierWalkLeft[5] = new TextureRegion(new Texture("animations/soldier_animation/c6.png"));
		soldierWalkLeft[6] = new TextureRegion(new Texture("animations/soldier_animation/c7.png"));
		soldierWalkLeft[7] = new TextureRegion(new Texture("animations/soldier_animation/c8.png"));
		soldierWalkLeft[8] = new TextureRegion(new Texture("animations/soldier_animation/c9.png"));

		soldierWalkRight = new TextureRegion[9];
		soldierWalkRight[0] = new TextureRegion(new Texture("animations/soldier_animation/d1.png"));
		soldierWalkRight[1] = new TextureRegion(new Texture("animations/soldier_animation/d2.png"));
		soldierWalkRight[2] = new TextureRegion(new Texture("animations/soldier_animation/d3.png"));
		soldierWalkRight[3] = new TextureRegion(new Texture("animations/soldier_animation/d4.png"));
		soldierWalkRight[4] = new TextureRegion(new Texture("animations/soldier_animation/d5.png"));
		soldierWalkRight[5] = new TextureRegion(new Texture("animations/soldier_animation/d6.png"));
		soldierWalkRight[6] = new TextureRegion(new Texture("animations/soldier_animation/d7.png"));
		soldierWalkRight[7] = new TextureRegion(new Texture("animations/soldier_animation/d8.png"));
		soldierWalkRight[8] = new TextureRegion(new Texture("animations/soldier_animation/d9.png"));

		skeletonRegion = new TextureRegion[5];
		skeletonRegion[0] = new TextureRegion(new Texture("animations/skeleton_animation/s1.png"));
		skeletonRegion[1] = new TextureRegion(new Texture("animations/skeleton_animation/s2.png"));
		skeletonRegion[2] = new TextureRegion(new Texture("animations/skeleton_animation/s3.png"));
		skeletonRegion[3] = new TextureRegion(new Texture("animations/skeleton_animation/s4.png"));
		skeletonRegion[4] = new TextureRegion(new Texture("animations/skeleton_animation/s5.png"));

		gameStart = System.currentTimeMillis();

		for(int i=0; i<level1; i++){
			Animator x = new Animator();
			x.setupAnimation(batch, panX + 3000 + i*300, 300, soldierWalkRight);
			game.gameState.level1Soldiers.add(new Soldier(soldierId++, game.textures.soldier,  3000 + i*300, x, 2));
		}
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Gdx.gl.glClearColor(1, 1, 1, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(backgroundUp,panX,0);
		batch.draw(background,panX,0);


		batch.draw(game.textures.magicCard,0,0);
		batch.draw(game.textures.warCard,182,0);
		batch.draw(game.textures.buildCard,364,0);
		font.draw(batch, "Gold : "+game.gameState.gold, 300, 1050);
		font.draw(batch, "Population : "+game.gameState.population, 700, 1050);
		font.draw(batch, "Magic : "+game.gameState.magic, 1200, 1050);
		//soldierAnimator.animate(true);

		batch.end();

		for (int i = 0; i < game.gameState.buildings.length; i++){
			if(game.gameState.buildings[i] != null){
				if(game.gameState.buildings[i].y > 285){
					game.gameState.buildings[i].y -= 5;
				}
				batch.begin();
				if(game.gameState.buildings[i] instanceof Barracks && ((Barracks)game.gameState.buildings[i]).isFighting){
					batch.end();
					continue;
				}
				batch.draw(game.gameState.buildings[i].texture, panX+game.gameState.buildings[i].x, 
						game.gameState.buildings[i].y);

				for(int j = 0; j < game.gameState.buildings[i].health; j++){

					batch.draw(game.textures.buildingHealth, panX+game.gameState.buildings[i].x + j*25 + 40, 
							game.gameState.buildings[i].y + 250);
				}
				batch.end();
				if(game.gameState.buildings[i].progress){
					game.gameState.buildings[i].bar.update(camera, 100, 
							panX+game.gameState.buildings[i].x - 20, game.gameState.buildings[i].y + 330);
					if(game.gameState.buildings[i].bar.progress == 10){
						game.gameState.buildings[i].progress = false;
					}
				}
			}
		}

		batch.begin();
		for(int i = 0; i < game.gameState.level1Soldiers.size(); i++){
			if(game.gameState.level1Soldiers.get(i).status.equals("dead"))
				continue;
			for(int j = 0; j <  game.gameState.level1Soldiers.get(i).health; j++){
				batch.draw(game.textures.healthBar, panX+game.gameState.level1Soldiers.get(i).x + (j)*25, 550);
			}
			if((game.gameState.level1Soldiers.get(i).x)/200 >= 0){
				if(game.gameState.buildings[(game.gameState.level1Soldiers.get(i).x)/200] != null){
					if(game.gameState.level1Soldiers.get(i).status.equals("walking")){
						Animator x = new Animator();
						x.setupAnimation(batch, game.gameState.level1Soldiers.get(i).x, 300, soldierAttackRight);
						game.gameState.level1Soldiers.get(i).anim = x;
						game.gameState.level1Soldiers.get(i).status = "attacking";

					}if(game.gameState.level1Soldiers.get(i).status.equals("attacking")){
						game.gameState.buildings[(game.gameState.level1Soldiers.get(i).x)/200].health--;
						if(game.gameState.buildings[(game.gameState.level1Soldiers.get(i).x)/200].health == 0){
							game.gameState.buildings[(game.gameState.level1Soldiers.get(i).x)/200] = null;
							game.gameState.level1Soldiers.get(i).status = "walking";
							continue;
						}
						if(game.gameState.buildings[(game.gameState.level1Soldiers.get(i).x)/200] instanceof Barracks){

							((Barracks)(game.gameState.buildings[(game.gameState.level1Soldiers.get(i).x)/200])).a.animate(true, panX);
							((Barracks)(game.gameState.buildings[(game.gameState.level1Soldiers.get(i).x)/200])).isFighting = true;
						}
					}
				}
			}

			game.gameState.level1Soldiers.get(i).anim.animate(true, panX);
			if(!game.gameState.level1Soldiers.get(i).status.equals("attacking")){
				game.gameState.level1Soldiers.get(i).anim.animationAreaX -= 1;
				game.gameState.level1Soldiers.get(i).x -= 1;
			}
		}
		if(level1==0 && !level1Over){
			level1Over = true;
			for(int i=0; i<level2; i++){
				Animator x = new Animator();
				x.setupAnimation(batch, panX + 9000 + i*300, 300, soldierWalkRight);
				game.gameState.level2Soldiers.add(new Soldier(soldierId++, game.textures.soldier, panX+9000 + i*300, x, 4));
			}
			backgroundUp = game.textures.background2;
		}

		if(level1==0){
			for(int i = 0; i < game.gameState.level2Soldiers.size(); i++){
				if(game.gameState.level2Soldiers.get(i).status.equals("dead"))
					continue;
				for(int j = 0; j <  game.gameState.level2Soldiers.get(i).health; j++){
					batch.draw(game.textures.healthBar, panX+game.gameState.level2Soldiers.get(i).x + (j)*25, 550);
				}
				if((game.gameState.level2Soldiers.get(i).x)/200 >= 0){
					if(game.gameState.buildings[(game.gameState.level2Soldiers.get(i).x)/200] != null){
						if(game.gameState.level2Soldiers.get(i).status.equals("walking")){
							Animator x = new Animator();
							x.setupAnimation(batch, game.gameState.level2Soldiers.get(i).x, 300, soldierAttackRight);
							game.gameState.level2Soldiers.get(i).anim = x;
							game.gameState.level2Soldiers.get(i).status = "attacking";
						}
					}
				}

				game.gameState.level2Soldiers.get(i).anim.animate(true, panX);
				if(!game.gameState.level2Soldiers.get(i).status.equals("attacking")){
					game.gameState.level2Soldiers.get(i).anim.animationAreaX -= 1;
					game.gameState.level2Soldiers.get(i).x -= 1;
				}

			}
		}
		if(level2==0 && !level2Over){
			level2Over = true;
			for(int i=0; i<level3; i++){
				Animator x = new Animator();
				x.setupAnimation(batch, panX + 11000 + i*300, 300, soldierWalkRight);
				game.gameState.level3Soldiers.add(new Soldier(soldierId++, game.textures.soldier, panX+11000 + i*300, x, 6));
			}
			backgroundUp = game.textures.background3;
			background = game.textures.gameBackground;
		}
		if(level2==0){

			for(int i = 0; i < game.gameState.level3Soldiers.size(); i++){
				if(game.gameState.level3Soldiers.get(i).status.equals("dead"))
					continue;

				for(int j = 0; j <  game.gameState.level3Soldiers.get(i).health; j++){
					batch.draw(game.textures.healthBar, panX+game.gameState.level3Soldiers.get(i).x + (j)*25, 550);
				}
				if((game.gameState.level3Soldiers.get(i).x)/200 >= 0){
					if(game.gameState.buildings[(game.gameState.level3Soldiers.get(i).x)/200] != null){
						if(game.gameState.level3Soldiers.get(i).status.equals("walking")){
							Animator x = new Animator();
							x.setupAnimation(batch, game.gameState.level3Soldiers.get(i).x, 300, soldierAttackRight);
							game.gameState.level3Soldiers.get(i).anim = x;
							game.gameState.level3Soldiers.get(i).status = "attacking";
						}
					}
				}

				game.gameState.level3Soldiers.get(i).anim.animate(true, panX);
				if(!game.gameState.level3Soldiers.get(i).status.equals("attacking")){
					game.gameState.level3Soldiers.get(i).anim.animationAreaX -= 1;
					game.gameState.level3Soldiers.get(i).x -= 1;
				}

			}
		}
		batch.end();

		if(System.currentTimeMillis() - startTime < 3000){
			batch.begin();
			font.draw(batch, "Cannot place building here. You can upgrade!", 500, 900);
			batch.end();
		}


		if(Gdx.input.justTouched()){

			tap.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(tap);

			int x = (int) tap.x;
			int y = (int) tap.y;

			for(int i = 0; i < game.gameState.level1Soldiers.size(); i++){
				if(x > panX + game.gameState.level1Soldiers.get(i).x && x < panX + game.gameState.level1Soldiers.get(i).x + 250 && 
						y < 600 && y > 300){
					game.gameState.level1Soldiers.get(i).health--;
					if(game.gameState.level1Soldiers.get(i).health == 0){
						game.gameState.level1Soldiers.get(i).status = "dead"; 
						level1--;
					}
				}
			}
			if(level1 == 0){
				for(int i = 0; i < game.gameState.level2Soldiers.size(); i++){
					if(x > panX + game.gameState.level2Soldiers.get(i).x && x < panX + game.gameState.level2Soldiers.get(i).x + 250 && 
							y < 600 && y > 300){
						game.gameState.level2Soldiers.get(i).health--;
						if(game.gameState.level2Soldiers.get(i).health == 0){
							game.gameState.level2Soldiers.get(i).status = "dead"; 
							level2--;
						}
					}
				}
			}
			if(level2 == 0){
				for(int i = 0; i < game.gameState.level3Soldiers.size(); i++){
					if(x > panX + game.gameState.level3Soldiers.get(i).x && x < panX + game.gameState.level3Soldiers.get(i).x + 250 && 
							y < 600 && y > 300){
						game.gameState.level3Soldiers.get(i).health--;
						if(game.gameState.level3Soldiers.get(i).health == 0){
							game.gameState.level3Soldiers.get(i).status = "dead"; 
							level3--;
							System.out.println(level3);
						}
					}
				}
			}


			// Touched magic card
			if(x < 180 && x > 0 && y < 280 && y > 0){
				placing = 1;	
			}
			// Touched war card
			if(x < 364 && x > 181 && y < 280 && y > 0){
				placing = 2;
			}
			// Touched build card
			if(x < 545 && x > 365 && y < 280 && y > 0){
				placing = 3;
			}
			if(placing != -1 && y > 300){
				x = Math.abs(x- panX);
				if(game.gameState.buildings[x/200] == null){
					if(placing == 1){
						game.gameState.buildings[x/200] = new Crypt((x/200)*200, y, game.textures.smallMagic); 
						builtFirstBuilding = true;

					}
					if(placing == 2){
						Animator a = new Animator();
						a.setupAnimation(batch, panX+(x/200)*200, 300, skeletonRegion);
						game.gameState.buildings[x/200] = new Barracks((x/200)*200, y, game.textures.smallMilitary, a);
						builtFirstBuilding = true;

					} 
					if(placing == 3){
						game.gameState.buildings[x/200] = new House((x/200)*200, y, game.textures.smallHouse); 
						builtFirstBuilding = true;
					}
					placing = -1;
				}else{
					startTime = System.currentTimeMillis();
				}
			}
			else if(placing == -1 && y > 300){
				x = Math.abs(x - panX);
				if(game.gameState.buildings[x/200] != null && game.gameState.buildings[x/200].progress == false){
					game.gameState.buildings[x/200].progress = true;
					game.gameState.buildings[x/200].bar = new CustomProgressBar();
				}
			}
		}

		if(builtFirstBuilding){
			boolean remains = false;
			for(int i=0; i<game.gameState.buildings.length; i++)
				if(game.gameState.buildings[i] != null)
					remains = true;

			if(!remains){
				startTime = 0;
				batch.begin();
				font.draw(batch, "You LOST", 300, 800);
				font.draw(batch, "Click anywhere to go main menu.", 300, 700);
				batch.end();
				if(System.currentTimeMillis() - startTime > 2000 && Gdx.input.justTouched()){
					game.setScreen(new MainMenuScreen(game));
				}

			}
		}
		if(level3 == 0){
			startTime = 0;

			batch.begin();
			font.draw(batch, "You WON", 300, 800);
			font.draw(batch, "Click anywhere to go main menu.", 300, 700);
			batch.end();
			if(System.currentTimeMillis() - startTime > 2000 && Gdx.input.justTouched()){
				game.setScreen(new MainMenuScreen(game));
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
			panX = 1920 - 8000;
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
