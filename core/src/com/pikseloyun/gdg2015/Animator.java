package com.pikseloyun.gdg2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {

    private int  FRAME_COLS;     
    private int  FRAME_ROWS;     

    Animation			walkAnimation;      
    Texture         	walkSheet;          
    TextureRegion[]     walkFrames;         
    SpriteBatch         spriteBatch;        
    TextureRegion       currentFrame;       
    
    float stateTime;                                        
    int animationAreaX, animationAreaY;
    
    public void setupAnimation(Texture walkSheet, SpriteBatch spriteBatch, int animationAreaX, int animationAreaY,
    		int frameColumns, int frameRows){
    	this.walkSheet = walkSheet;
    	this.spriteBatch = spriteBatch;
    	this.animationAreaX = animationAreaX;
    	this.animationAreaY = animationAreaY;
    	this.FRAME_COLS = frameColumns;
    	this.FRAME_ROWS = frameRows;
    	
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, 
        		walkSheet.getHeight()/FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.025f, walkFrames);
        stateTime = 0f;
    }

    public void animate() {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        spriteBatch.draw(currentFrame, animationAreaX, animationAreaX);
    }

}
