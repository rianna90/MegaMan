package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MegaMan extends Actor {
	
	private Sprite _megaMan;
    private int _currentFrame = 5;
    private int _frameWidth = 34;
    private float _animationTime = 0.1f;
    private float _currentAnimationTime = 0;

    private int _speed;
    private int _jumpSpeed;
    public boolean left = false;
    
    private float _posX, _posY;     		 // Position of the character
    private float _velocityX = 4.0f;
    private float _velocityY = 0;    				// Velocity of the character
    private float _gravity = 0.5f;           // How strong is gravity
    private boolean onGround = false;

    
    public enum MegaManState
    {
        Standing,
    	WalkLeft,
    	WalkRight,
        JumpUp,
        JumpDown,
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
		   _velocityY += _gravity;
		    _posY += _velocityY;
		    //_posX += _velocityX;

		    if(_posY > 28.0)
		    {
		        _posY = 28.0f;
		        _velocityY = 0.0f;
		        onGround = true;
		        Gdx.app.log("MegaMan", "posy true");
		    }
		    
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
			 _posX += _speed;
			AnimateLeft();	
		}
		if(state == MegaManState.WalkRight)
		{
			 _posX += _speed;
			AnimateRight();	
		}
		if(state == MegaManState.JumpUp)
		{
			StartJump();
		}
		if(state == MegaManState.JumpDown)
		{
			EndJump();
		}

	}
	
	public void StartJump()
	{
	    if(onGround)
	    {
	        _velocityY = -12.0f;
	        //onGround = false;
	    }
	}

	public void EndJump()
	{
	    if(_velocityY < -6.0f)
	        _velocityY = -6.0f;
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
