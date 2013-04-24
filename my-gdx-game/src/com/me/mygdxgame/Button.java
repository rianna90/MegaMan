package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button extends Sprite {

	private Texture _texture;
	private int _posX;
	private int _posY;

	public Button(Texture t, int x, int y)
	{
		_texture = t;
		_posX = x;
		_posY = y;
	}
	
	public void draw(SpriteBatch spriteBatch)
	{
		//spriteBatch.begin();
		spriteBatch.draw(_texture, _posX, _posY);
		//spriteBatch.end();
		//super.draw(spriteBatch);
	}
	
}
