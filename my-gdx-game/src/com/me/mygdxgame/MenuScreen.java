package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MenuScreen implements Screen, InputProcessor {
	
	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
    private Game myGame;
    private Sprite resumeBtn;
    private Sprite mainBtn;
    public Vector3 touchpoint;
    
	public MenuScreen(Game g)
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
        spriteBatch.draw(Assets.menubg, 290, 200);
        
        
        resumeBtn = new Sprite(Assets.resumeBtn);
        resumeBtn.setPosition(340, 230);
        resumeBtn.draw(spriteBatch);
        
        mainBtn = new Sprite(Assets.mainBtn);
        mainBtn.setPosition(340, 290);
        mainBtn.draw(spriteBatch);


        spriteBatch.draw(Assets.platformBase,  0, 0, 800, 28, 0, 0, 800, 28, false, false);

        spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	
	}

	@Override
	public void show() {
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
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		touchpoint = new Vector3(screenX, screenY, 0);
		camera.unproject(touchpoint);
		
		if(resumeBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			myGame.setScreen(new GameScreen(myGame));
		}
		
		if(mainBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			myGame.setScreen(new StartScreen(myGame));
		}
		
		return true;
	}

	@Override
	public void dispose() {
		//spriteBatch.dispose();		
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
