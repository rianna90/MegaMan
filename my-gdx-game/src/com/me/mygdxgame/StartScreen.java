package com.me.mygdxgame;
import java.awt.Font;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class StartScreen implements Screen, InputProcessor {
	
	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
    private Game myGame;
    public static String string = "hello";
    public static Font font;
    String homeText;
    public int number;
    public Vector3 touchpoint;
    private Sprite playBtn;
    
    //hoi
	public StartScreen(Game g)
	{
		myGame = g;
		Gdx.input.setInputProcessor(this);
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
        
        
        playBtn = new Sprite(Assets.playBtn);
        playBtn.setPosition(290, 100);
        playBtn.draw(spriteBatch);
        
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		touchpoint.set(screenX, screenY, 0);
		Gdx.app.log("hoi", "touchpoint");
		camera.unproject(touchpoint);
		
		if(playBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
				{
					Gdx.app.log("hoooi", "hij doet het");
				}
		else
				{
					Gdx.app.log("hoooi", "hij doet het niet");
				}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

