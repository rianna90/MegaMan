package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Coins extends GameObject {
	SpriteBatch spritebatch;

	public static final float coin_width = 0.5f;
	public static final float coin_height = 0.8f;
	public static final int coin_score = 10;
	
	float stateTime;

	public Coins (float x, float y) {
		super(x, y, coin_width, coin_height);
		stateTime = 0;
	}

	public void update (float deltaTime) {
		stateTime += deltaTime;
	}
}
