package ch.ansermgw.angryword;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.ansermgw.angryword.models.Bird;

public class AngrywordMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	Bird bird;
	
	@Override
	public void create () {
		this.bird = new Bird(0, 0);
	}

	@Override
	public void render () {
		batch.begin();
		bird.draw(batch);
		batch.begin();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
