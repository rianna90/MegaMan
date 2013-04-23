package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Platform extends Actor {
	SpriteBatch spritebatch;

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(Assets.platformMiddle, 100,100);
		batch.draw(Assets.platformBase,  0, 0, 800, 28, 0, 0, 800, 28, false, false);
	}

}

