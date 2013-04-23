package com.me.mygdxgame;

import java.awt.Font;

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
    public static String string = "hello";
    public static Font font;
    String homeText;
    public int number;
    
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
        spriteBatch.draw(Assets.homebg, 80, 60);
        spriteBatch.draw(Assets.charfullbody, 310, 170);
        spriteBatch.draw(Assets.playBtn, 290, 100);
        spriteBatch.draw(Assets.platformBase,  0, 0, 800, 28, 0, 0, 800, 28, false, false);
        spriteBatch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        Assets.font.draw(spriteBatch, homeText, 16, 480 - 20);
        spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	
	}

	@Override
	public void show() {
		 number = 10;
		 homeText = "Experience Points " + number;
		 spriteBatch = new SpriteBatch();
		 camera = new OrthographicCamera();
		 camera.setToOrtho(false, 800, 600);	
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
