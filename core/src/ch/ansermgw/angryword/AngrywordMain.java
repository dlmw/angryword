package ch.ansermgw.angryword;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.ansermgw.angryword.models.Bird;

public class AngrywordMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	Bird bird;

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.bird = new Bird(0, 0);
	}

	@Override
	public void render () {
		batch.begin();
		bird.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
