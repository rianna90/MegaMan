package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame extends Game {

	//private SpriteBatch batch;	
	GameScreen gameScreen;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Platform Platform;

	
	@Override
	public void create() {		
		//batch = new SpriteBatch();

		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		Platform = new Platform();
		Platform.create();
		
		Assets.load();
		
		gameScreen = new GameScreen(this);

		setScreen(gameScreen);  
		Gdx.app.log("MyTag", "create");

	}

	@Override
	public void dispose() {
		//batch.dispose();
	}


	@Override
	public void render() {	
		
		//gameScreen.render(0);
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
	    batch.begin();
	    batch.draw(Assets.background,  0, 0, 800, 600, 0, 0, 800, 600, false, false);

	    Platform.setSpritebatch(batch);
	    Platform.renderPlatform();
		batch = Platform.getSpritebatch();
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
