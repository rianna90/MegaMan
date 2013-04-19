package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	private OrthographicCamera camera;
	SpriteBatch batch;	
	MyGdxGame game; 
	
	public GameScreen(MyGdxGame game) {		
		
		this.game = game;

		
		batch = new SpriteBatch();
		
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);	
	    
	    Gdx.app.log("GameScreen", "constructor");
	}
	
	@Override
	public void render(float delta) {
		Gdx.app.log("GameScreen", "render");
	    camera.update();
		
	    batch.setProjectionMatrix(camera.combined);
		
		batch.begin();		
		batch.draw(Assets.background, 0, 0);
		batch.end();	
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.app.log("GameScreen", "show");		
	}

	@Override
	public void hide() {
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
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
