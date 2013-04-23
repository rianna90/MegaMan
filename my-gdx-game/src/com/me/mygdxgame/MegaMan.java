package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MegaMan extends Actor {
	
    private int _currentFrame = 0;
    private int _frameWidth = 36;
    private float _animationTime = 0.1f;
    private float _currentAnimationTime = 0;
    
	public MegaMan () 
	{

	}
	
	public void act(float delta)
	{
		_currentAnimationTime += Gdx.graphics.getDeltaTime();//gameTime.ElapsedGameTime.Milliseconds;
		
        if (_currentAnimationTime >= _animationTime)
        {       	
            _currentFrame++;
            _currentAnimationTime = 0;
            
            if(_currentFrame == 4)
            {
            	_currentFrame = 0;
            }
        }
	}
	
    private TextureRegion getCurrentFrame()
    {
        return new TextureRegion(Assets.megaman,_frameWidth * _currentFrame, 0, 36, 33);
    }
    
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		batch.draw(getCurrentFrame(), 100, 25);
	}
}
