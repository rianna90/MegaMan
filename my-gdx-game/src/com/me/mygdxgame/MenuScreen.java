package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen implements Screen {
	
	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
    private Game myGame;
    
	public MenuScreen(Game g)
	{
		myGame = g;
	}

	@Override
	public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    camera.update();		
	    spriteBatch.setProjectionMatrix(camera.combined);
	   
        spriteBatch.begin();
        spriteBatch.draw(Assets.bg, 0, 0);
        spriteBatch.draw(Assets.playBtn, 0, 0);
        spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	
	}

	@Override
	public void show() {
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
