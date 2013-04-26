package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class Pedometer implements ApplicationListener {
	
	private float mLastX, mLastY, mLastZ;
	private final float NOISE = (float) 7.0;
	
	public Pedometer()
	{
	 
	}

	@Override
	public void create() {
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void render() {
		
		float x = Gdx.input.getAccelerometerX();
	    float y = Gdx.input.getAccelerometerY();
	    float z = Gdx.input.getAccelerometerZ();
	    
		float deltaX = Math.abs(mLastX - x);
		float deltaY = Math.abs(mLastY - y);
		float deltaZ = Math.abs(mLastZ - z);
		if (deltaX < NOISE) deltaX = (float)0.0;
		if (deltaY < NOISE) deltaY = (float)0.0;
		if (deltaZ < NOISE) deltaZ = (float)0.0;
		
		mLastX = x;
		mLastY = y;
		mLastZ = z;

		// horizontal
		if (deltaX > deltaY) {
			//Gdx.app.log("Pedometer", "horizontal");
			Step.getInstance().addSteps(1);

		// vertical
		} else if (deltaY > deltaX) {
			//Gdx.app.log("Pedometer", "vertical");
			Step.getInstance().addSteps(1);
		} 
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
