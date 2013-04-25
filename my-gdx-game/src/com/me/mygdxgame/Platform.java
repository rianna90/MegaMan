package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Platform extends Actor {

	private Texture _texture;
	private int _posX;
	private int _posY;
	private int _width;
	private int _height;
	
	public Platform(Texture texture, int x, int y, int width, int height)
	{
		_texture = texture;
		_posX = x;
		_posY = y;
		_width = width;
		_height = height;		
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(_texture, _posX, _posY, _width, _height);
	}
	
    // Boundingbox voor collision 
    public Rectangle BoundingBox()
    {
        return new Rectangle(
            _posX,
            _posY,
            _width,
            _height
            );       
    }
}

