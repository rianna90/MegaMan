package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameScreen implements Screen {

	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
	private Game myGame;
	private Platform platform;
	private Stage stage;
	private MegaMan mm;
	private Button btn;
	
	private Pedometer pd;
	
	public GameScreen(Game g) {		
		
		myGame = g;
		Gdx.input.setInputProcessor(stage);	
	}
	
	@Override
	public void render(float delta) {
				
	    camera.update();		
	    spriteBatch.setProjectionMatrix(camera.combined);
		
	    spriteBatch.begin();	
	    stage.draw();
	    spriteBatch.end();	
	    	    
	    spriteBatch.begin();		    
	    spriteBatch.draw(Assets.background, 0, 0);	   
	    platform.draw(spriteBatch, delta);
	    
	    btn.draw(spriteBatch, delta);
	    mm.draw(spriteBatch, delta);
	    mm.act(delta); 
	    
	    spriteBatch.end();	  
	    
	    pd.render();
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		
		mm = new MegaMan();
		btn = new Button();
		
		stage.addActor(mm);
		stage.addActor(btn);
		
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

}
