package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameScreen implements Screen {

	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
	private Game myGame;
	private Platform platform;
	private Stage stage;
	private MegaMan mm;
	private Button btn;
	
	public GameScreen(Game g) {		
		
		myGame = g;
	}
	
	@Override
	public void render(float delta) {
		Gdx.input.setInputProcessor(stage);
		
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
