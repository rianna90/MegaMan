package com.me.mygdxgame;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	
	SplashScreen splashScreen;

	@Override
	public void create() {		

		Assets.load();
		
<<<<<<< HEAD
		//setScreen(new SplashScreen(this));
		setScreen(new GameScreen(this));
		//setScreen(new MenuScreen(this));
=======
		setScreen(new SplashScreen(this));
		//setScreen(new GameScreen(this));
>>>>>>> Steps count start screen
	}

	@Override
	public void dispose() {

	}


	@Override
	public void render() {	
		
		 super.render();
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
