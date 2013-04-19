package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame extends Game {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	@Override
	public void create() {		

		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
	
		Assets.load();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {		
	    camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		
		TextureRegion keyFrame;
		keyFrame = Assets.megamanWalk.getKeyFrame(5, Animation.ANIMATION_NONLOOPING);
		
		batch.begin();
		batch.draw(Assets.background,  0, 0, 800, 600, 0, 0, 800, 600, false, false);
		batch.draw(keyFrame, 10, 10);
		//batch.draw(Assets.megaman, 10, 10);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
