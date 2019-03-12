package com.vpr.zombies;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import pantallas.PantallaSplash;

public class PracticaZombies extends Game {
	
	@Override
	public void create () {
		Gdx.graphics.setWindowedMode(1280, 720);
		setScreen(new PantallaSplash());
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
