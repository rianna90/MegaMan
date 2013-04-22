package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;


public class MyGdxGame extends Game {
<<<<<<< HEAD
	
	//private SpriteBatch batch;	
	GameScreen gameScreen;
=======
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Platform Platform;
>>>>>>> Platform, get set spritebatch
	
	@Override
	public void create() {		

<<<<<<< HEAD
		//batch = new SpriteBatch();
=======
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		Platform = new Platform();
		Platform.create();
		
>>>>>>> Platform, get set spritebatch
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
<<<<<<< HEAD
	public void render() {		
		gameScreen.render(0);
=======
	public void render() {	
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
	    batch.begin();
	    batch.draw(Assets.background,  0, 0, 800, 600, 0, 0, 800, 600, false, false);

	    Platform.setSpritebatch(batch);
	    Platform.renderPlatform();
		batch = Platform.getSpritebatch();
		
		TextureRegion keyFrame;
		keyFrame = Assets.megamanWalk.getKeyFrame(5, Animation.ANIMATION_NONLOOPING);
		//batch.draw(Assets.platformBase, 0, 0, 800, 28, 0, 0, 800, 28, false, false);
		batch.draw(keyFrame, 10, 10);
		//batch.draw(Assets.megaman, 10, 10);
		batch.end();
>>>>>>> Platform, get set spritebatch
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
