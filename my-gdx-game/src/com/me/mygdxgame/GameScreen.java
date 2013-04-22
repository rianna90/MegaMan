package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
	private Game myGame;
	private Platform platform;
	
	public GameScreen(Game g) {		
		
		myGame = g;
	}
	
	@Override
	public void render(float delta) {
	    camera.update();		
	    spriteBatch.setProjectionMatrix(camera.combined);
		
	    spriteBatch.begin();		
	    spriteBatch.draw(Assets.background, 0, 0);

	    //platform.setSpritebatch(spriteBatch);
	    //platform.renderPlatform();
	    //spriteBatch = platform.getSpritebatch();
	    spriteBatch.end();	
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {

		//platform.create();	
		spriteBatch = new SpriteBatch();
		
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);			
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}

}
