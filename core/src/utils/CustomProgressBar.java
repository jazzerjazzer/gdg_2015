package utils;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.TimeUtils;


public class CustomProgressBar {

	private ShapeRenderer mShapeRenderer;
	private long startTime = 0;
	public int progress = 0;
	public CustomProgressBar(){
		mShapeRenderer = new ShapeRenderer();
		startTime = TimeUtils.nanoTime();
	}

	public void update(Camera camera, int time, int x, int y) {

		long currentTimeStamp = TimeUtils.nanoTime();
		if (currentTimeStamp - startTime > TimeUtils.millisToNanos(time)) {
			startTime = currentTimeStamp;
			progress++;
		}
		// Width of progress bar on screen relevant to Screen width
		float progressBarWidth = 20 * progress;
		camera.update();
		mShapeRenderer.setProjectionMatrix(camera.combined);
		mShapeRenderer.begin(ShapeType.Filled);
		mShapeRenderer.setColor(Color.RED);
		mShapeRenderer.rect(x, y, progressBarWidth, 10);
		mShapeRenderer.end();
		
	}
}
