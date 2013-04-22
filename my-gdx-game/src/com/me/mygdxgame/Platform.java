package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Platform extends Game {
	SpriteBatch spritebatch;

	public void render(){
		renderPlatform();
	}
	
	public void renderPlatform(){
		spritebatch.draw(Assets.platformMiddle, 100,100);
		spritebatch.draw(Assets.platformBase,  0, 0, 800, 28, 0, 0, 800, 28, false, false);
	}

	@Override
	public void create() {

	}

	public SpriteBatch getSpritebatch() {
		return spritebatch;
	}

	public void setSpritebatch(SpriteBatch spritebatch) {
		this.spritebatch = spritebatch;
	}
	

}

