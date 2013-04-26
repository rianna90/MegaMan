package com.me.mygdxgame;

import java.util.Iterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.me.mygdxgame.MegaMan.MegaManState;

// Screen waarin het level zich afspeelt
public class GameScreen implements Screen,  InputProcessor  {

	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
	private Game myGame;

	private MegaMan mm;
	private Sprite leftArrowBtn;
	private Sprite rightArrowBtn;
	private float leftBtnAlpha;
    private float rightBtnAlpha;
	//private Sprite upArrowBtn;	

	private Sprite pauseBtn;
    private Vector3 touchpoint;
    
    private Array<Rectangle> coins;
    private long lastDropTime;
    private String coinText;
      
	public GameScreen(Game g) {		
		
		myGame = g;
		Gdx.input.setInputProcessor(this);	
	}
	
	@Override
	public void render(float delta) {

	    camera.update();		
	    spriteBatch.setProjectionMatrix(camera.combined);
			    	    
	    spriteBatch.begin();	
	    
	    spriteBatch.draw(Assets.bg, 0, 0);	   
	    spriteBatch.draw(Assets.platformBase, 0, 0);

	    mm.draw(spriteBatch, delta);	    
	    mm.act(delta); 
	    
        leftArrowBtn = new Sprite(Assets.btn);
        leftArrowBtn.setPosition(50, 30);
        leftArrowBtn.setScale(2);
        leftArrowBtn.draw(spriteBatch, leftBtnAlpha);
	    
        rightArrowBtn = new Sprite(Assets.btn);
        rightArrowBtn.rotate(180);
        rightArrowBtn.setPosition(700, 30);
        rightArrowBtn.setScale(2);
        rightArrowBtn.draw(spriteBatch, rightBtnAlpha);
        
       // upArrowBtn = new Sprite(Assets.btn);
       // upArrowBtn.setPosition(740, 10);
       // upArrowBtn.rotate(-90);
       // upArrowBtn.setScale(1.5f);
       // upArrowBtn.draw(spriteBatch);
       
        pauseBtn = new Sprite(Assets.pauseBtn);
        pauseBtn.scale(0.5f);
        pauseBtn.setPosition(730, 540);
        pauseBtn.draw(spriteBatch);
        
		coinText = "Coins: " + Coin.getInstance().coins;
	    Assets.font.draw(spriteBatch, coinText, 16, 580);
	    
	    for(Rectangle coin: coins) {
	    	spriteBatch.draw(Assets.coin, coin.x, coin.y);
		    }
	    
	    spriteBatch.end();	  
	    
		//if (OverlapTester.overlapRectangles(mm.BoundingBox(), platform.BoundingBox())) 
		//{
		//	Gdx.app.log("GameScreen", "Hit platform");	
		//	mm.state = MegaManState.HitPlatform;
		//}
	    
	    if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnCoindrop();
	    
	    Iterator<Rectangle> iter = coins.iterator();
	    while(iter.hasNext()) {
	       Rectangle coin = iter.next();
	       coin.y -= 200 * Gdx.graphics.getDeltaTime();
	       if(coin.y + 48 < 0) iter.remove();
	       
	       if(coin.overlaps(mm.BoundingBox())) {
	    	   Coin.getInstance().addCoins(1);
	           iter.remove();
	        }
	    }
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() 
	{
		spriteBatch = new SpriteBatch();		
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 600);	
	    leftBtnAlpha = 70;
	    rightBtnAlpha = 70;
	    
		mm = new MegaMan();		
		coins = new Array<Rectangle>();
		spawnCoindrop();
	}
	
	private void spawnCoindrop() 
	{
		      Rectangle raindrop = new Rectangle();
		      raindrop.x = MathUtils.random(0, 800-48);
		      raindrop.y = 480;
		      raindrop.width = 48;
		      raindrop.height = 48;
		      coins.add(raindrop);
		      lastDropTime = TimeUtils.nanoTime();
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
	     Assets.coin.dispose();
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
			leftBtnAlpha = 10;
			mm.state = MegaManState.WalkLeft;
			mm.left = true;
			mm.setSpeed(-5);		
		}
		
		if(rightArrowBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			rightBtnAlpha = 10;
			mm.state = MegaManState.WalkRight;
			mm.left = false;

			mm.setSpeed(5);			
		}		
           
		/*if(upArrowBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
				mm.state = MegaManState.JumpUp;				
		}*/		

		
		if(pauseBtn.getBoundingRectangle().contains(touchpoint.x, touchpoint.y))
		{
			myGame.setScreen(new MenuScreen(myGame));
		}
		
		return true;		
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	
		rightBtnAlpha = 70;
		leftBtnAlpha = 70;
		mm.state = MegaManState.Standing;

		//if(mm.jump == true)
		//{
		//	mm.state = MegaManState.JumpDown;
		//}
		
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
