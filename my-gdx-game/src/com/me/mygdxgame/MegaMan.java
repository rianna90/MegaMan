package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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
    public boolean jump = false;
    
    //public float _posX, _posY;     		 // Position of the character
    //private float _velocityY = 0;    		// Velocity of the character
    //private float _gravity = 0.5f;           // How strong is gravity
    //private boolean onGround = false;
    
    boolean jumping; //Is the character jumping?
    float startY, jumpspeed = 0; //startY to tell us //where it lands, jumpspeed to see how fast it jumps
    
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
        HitPlatform,
        Falling,

        Dead
    }
    
    public MegaManState state = MegaManState.Standing;
    
	public MegaMan () 
	{
		_posX = 100;
		_posY = 28;
		//_speed = 0;
		
		_megaMan = new Sprite(Assets.megaman);
		
		startY = _posY;//Starting position
		jumping = false;//Init jumping to false
		jumpspeed = 0;//Default no speed
	}
	
    // Boundingbox voor collision 
    public Rectangle BoundingBox()
    {
        return new Rectangle(
            (int) _posX,
            (int) _posY,
            _frameWidth,
            _megaMan.getHeight()
            );       
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
		  /*  if(_posY > 100.0)
		    {
			    _velocityY = -3.0f;
		        onGround = true;
		    }
		    if(_posY <= 0)
		    {
		    	_posY = 0;
		    }*/
		    
		if (jumping)
		{
			_posY += jumpspeed;//Making it go up
			Gdx.app.log("MM", "Posy: " + Float.toString(_posY));
			
		    jumpspeed += 1;//Some math (explained later)
		    Gdx.app.log("MM", "Jumpspeed: " + Float.toString(jumpspeed));
		    
		        if (_posY >= 100)
		        //If it's farther than ground
		        {
		        	_posY = startY;//Then set it on
		               jumping = false;
		        }
		    }

		else
		{
			if(state == MegaManState.JumpUp)
			{
		        jumping = true;
		        jumpspeed = 14;//Give it upward thrust
		    }
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

		//if(state == MegaManState.JumpUp)
		//{
		//    _velocityY += _gravity;
		    
			//StartJump();
		//}
		if(state == MegaManState.JumpDown)
		{
			//EndJump();
		}
		if(state == MegaManState.HitPlatform)
		{
			_posY = 50;
		}
		   _posY += _velocityY;

	}
	
	/*public void StartJump()
	{
	    if(onGround)
	    {
	        _velocityY = 7.0f;
	        onGround = false;
	       
	    }
	}

	public void EndJump()
	{

	    if(_velocityY < -6.0f)
	        _velocityY = -6.0f;
	    
	}*/
	
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
