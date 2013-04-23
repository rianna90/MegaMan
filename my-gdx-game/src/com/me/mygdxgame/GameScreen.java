package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen,  InputProcessor  {

	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
	private Game myGame;
	private Platform platform;
	private Stage stage;
	private MegaMan mm;
	private Sprite leftArrowBtn;
	private Sprite rightArrowBtn;
    private Vector3 touchpoint;
    
    
	public GameScreen(Game g) {		
		
		myGame = g;
		Gdx.input.setInputProcessor(this);	
	}
	
	@Override
	public void render(float delta) {
				
	    camera.update();		
	    spriteBatch.setProjectionMatrix(camera.combined);
		
	    spriteBatch.begin();	
	    stage.draw();
	    spriteBatch.end();	
	    	    
	    spriteBatch.begin();		    
	    spriteBatch.draw(Assets.bg, 0, 0);	   
	    platform.draw(spriteBatch, delta);
	    
	    mm.draw(spriteBatch, delta);
	    mm.act(delta); 
	    
        leftArrowBtn = new Sprite(Assets.btn);
        leftArrowBtn.setPosition(10, 10);
        leftArrowBtn.draw(spriteBatch);
	    
        rightArrowBtn = new Sprite(Assets.btn);
        rightArrowBtn.setPosition(100, 10);
        rightArrowBtn.draw(spriteBatch);
        
	    spriteBatch.end();	  
	    
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		
		mm = new MegaMan();		
		stage.addActor(mm);
		
		platform = new Platform();	
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
		touchpoint = new Vector3(screenX, screenY, 0);
		camera.unproject(touchpoint);
		
		if(leftArrowBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			Gdx.app.log("GameScreen", "Left!");
		}
		if(rightArrowBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			Gdx.app.log("GameScreen", "Right");
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
