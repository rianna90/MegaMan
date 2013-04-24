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
import com.me.mygdxgame.MegaMan.MegaManState;

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
    private Coins coins;
    private String coinText;
    private int amountOfCoins;
    private Pedometer pd;
    
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
	    
	    amountOfCoins = 0;
	    	    
	    spriteBatch.begin();		    
	    spriteBatch.draw(Assets.bg, 0, 0);	   
	    platform.draw(spriteBatch, delta);

	    
	    Assets.font.draw(spriteBatch, coinText, 16, 480 - 20);
		
	    mm.draw(spriteBatch, delta);
	    mm.act(delta); 
	    
        leftArrowBtn = new Sprite(Assets.btn);
        leftArrowBtn.setPosition(10, 10);
        leftArrowBtn.setScale(1.5f);
        leftArrowBtn.draw(spriteBatch);
	    
        rightArrowBtn = new Sprite(Assets.btn);
        rightArrowBtn.rotate(180);
        rightArrowBtn.setPosition(100, 10);
        rightArrowBtn.setScale(1.5f);
        rightArrowBtn.draw(spriteBatch);
        
	    spriteBatch.end();	  
	    
	    pd.render();	 

	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
		coinText = "Coins: " + amountOfCoins;
		
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		
		mm = new MegaMan();		
		stage.addActor(mm);
		
		platform = new Platform();	
		spriteBatch = new SpriteBatch();
		
		
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);		
	    
	    pd = new Pedometer();
	   
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

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		return false;
	}

	@Override
	public boolean keyTyped(char character) {

		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touchpoint = new Vector3(screenX, screenY, 0);
		camera.unproject(touchpoint);
	    
		if(leftArrowBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			mm.state = MegaManState.WalkLeft;
			mm.left = true;
			mm.setSpeed(-2);		
		}
		
		if(rightArrowBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			mm.state = MegaManState.WalkRight;
			mm.left = false;
			mm.setSpeed(2);			
		}
		
		return true;		
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	
		mm.state = MegaManState.Standing;
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		return false;
	}

	@Override
	public boolean scrolled(int amount) {

		return false;
	}
	

}
