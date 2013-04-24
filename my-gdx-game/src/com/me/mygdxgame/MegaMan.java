package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MegaMan extends Actor {
	
	private Sprite _megaMan;
    private int _currentFrame = 5;
    private int _frameWidth = 36;
    private float _animationTime = 0.1f;
    private float _currentAnimationTime = 0;
    private int _posX;
    private int _posY;
    private int _speed;
    public boolean left = false;
    
    public enum MegaManState
    {
        Standing,
    	WalkLeft,
    	WalkRight,
        JumpLeft,
        JumpRight,
        Dead
    }
    
    public MegaManState state = MegaManState.Standing;
    
	public MegaMan () 
	{
		_posX = 100;
		_posY = 25;
		_speed = 0;
		
		_megaMan = new Sprite(Assets.megaman);
	}
	
    public void setSpeed(int speed) 
    {
       this._speed = speed;
    }

    public Integer getSpeed() 
    {
       return _speed;
    }
	
	public void act(float delta)
	{
		Boundaries();
		if(state == MegaManState.Standing)
		{
			_speed = 0;
			if(left == true)
			{
				_currentFrame = 4;
			}
			else if(!left)
			{
				_currentFrame = 5;
			}			
		}
		if(state == MegaManState.WalkLeft)
		{
			AnimateLeft();	
		}
		if(state == MegaManState.WalkRight)
		{
			AnimateRight();	
		}
		
        _posX += _speed;
	}
	
	private void AnimateRight() {
		_currentAnimationTime += Gdx.graphics.getDeltaTime();
		
        if (_currentAnimationTime >= _animationTime)
        {       	
            _currentFrame++;
            _currentAnimationTime = 0;
            
            if(_currentFrame == 9)
            {
            	_currentFrame = 5;
            }
        }		
	}

	public void AnimateLeft()
	{
		_currentAnimationTime += Gdx.graphics.getDeltaTime();
		
        if (_currentAnimationTime >= _animationTime)
        {       	
            _currentFrame--;
            _currentAnimationTime = 0;
            
            if(_currentFrame == 0)
            {
            	_currentFrame = 4;
            }
        }
	}
	
    private void Boundaries()
    {  	
        // boundary rechts
        if (_posX + _frameWidth > 800)
        {
            _posX = (int) (800 - _frameWidth);
        }
        // boundary links
        else if (_posX < 0)
        {
            _posX = 0;
        }
    }
	
    private TextureRegion getCurrentFrame()
    {
        return new TextureRegion(_megaMan,_frameWidth * _currentFrame, 0, 36, 33);
    }
    
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {

		batch.draw(getCurrentFrame(), _posX, _posY);
	}
}
