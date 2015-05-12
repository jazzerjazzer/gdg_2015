package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {

    public Animation			walkAnimation;      
    public TextureRegion[]     walkFrames;         
    SpriteBatch         spriteBatch;        
    TextureRegion       currentFrame;       
    boolean stop = true;
    float stateTime;                                        
    public int animationAreaX, animationAreaY;
    
    public void setupAnimation(SpriteBatch spriteBatch, int animationAreaX, int animationAreaY, TextureRegion[] walkFrames, float speed){
    	this.spriteBatch = spriteBatch;
    	this.animationAreaX = animationAreaX;
    	this.animationAreaY = animationAreaY;
    	this.walkFrames = walkFrames;
        walkAnimation = new Animation(speed, walkFrames);
        stateTime = 0f;
    }

    public void animate(boolean start, int panX) {
    	if(start){
    		stateTime += Gdx.graphics.getDeltaTime();
            currentFrame = walkAnimation.getKeyFrame(stateTime, true);
            spriteBatch.draw(currentFrame, panX + animationAreaX, animationAreaY);
    	}
    }

}
