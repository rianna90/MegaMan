package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MegaMan extends Actor {
	
    private int _currentFrame = 1;
    private int _frameWidth = 40;
    private int _animationTime = 40;
    private int _currentAnimationTime = 0;

    private float _timer = 0.2f;
    private float _TIMER = 0.2f;

    MyGdxGame game;
    
	public MegaMan (MyGdxGame game) 
	{
		this.game = game;

	}
	
    private Rectangle getCurrentFrame()
    {
        return new Rectangle(_frameWidth * _currentFrame, 0, 40, 40);
    }
    
    private void AnimateSpaceship()
    {
        _currentAnimationTime += Gdx.graphics.getDeltaTime();//gameTime.ElapsedGameTime.Milliseconds;

        if (_currentAnimationTime > _animationTime)
        {
            _currentFrame++;
            _currentAnimationTime = 0;
        }
    }
    
    public void render ()
    {
    	//MyGdxGame.batch.draw(Assets.megaman, 0, 0);
    	
    }
}
