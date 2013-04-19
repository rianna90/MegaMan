package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;


public class MyGdxGame extends Game {
	
	//private SpriteBatch batch;	
	GameScreen gameScreen;
	
	@Override
	public void create() {		

		//batch = new SpriteBatch();
		Assets.load();
		
		gameScreen = new GameScreen(this);

		setScreen(gameScreen);  
		Gdx.app.log("MyTag", "create");

	}

	@Override
	public void dispose() {
		//batch.dispose();
	}

	@Override
	public void render() {		
		gameScreen.render(0);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
