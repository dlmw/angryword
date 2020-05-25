package ch.ansermgw.angryword;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ch.ansermgw.angryword.models.Bird;
import ch.ansermgw.angryword.models.Block;
import ch.ansermgw.angryword.models.PhysicalObject;
import ch.ansermgw.angryword.models.Pig;
import ch.ansermgw.angryword.models.Tnt;
import ch.ansermgw.angryword.models.Wasp;

public class AngrywordMain extends Game {
	public static Random rand;

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
	public static final int FLOOR_HEIGHT = 150;

	private static final String BACKGROUND_NAME = "background.jpg";

	private Texture background;
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private Bird bird;
	private Wasp wasp;
	private Scenery scenery;

	@Override
	public void create () {
		batch = new SpriteBatch();

		rand = new Random(System.currentTimeMillis());
		background = new Texture(BACKGROUND_NAME);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();

		this.scenery = new Scenery();
		scenery.addFloor();

		this.bird = new Bird(new Vector2(100, Math.abs(WORLD_HEIGHT/4)), new Vector2(50, 150));
		this.wasp = new Wasp(new Vector2(Math.abs(WORLD_WIDTH/2), Math.abs(WORLD_HEIGHT/2)));

		for (int i = 10; i < 13; i++) {
			scenery.addElement(new Pig(new Vector2(i * 60, FLOOR_HEIGHT + 50)));
		}

		for (int i = 1; i < 5; i++) {
			scenery.addElement(new Tnt(new Vector2(Math.abs(WORLD_WIDTH/4*3), FLOOR_HEIGHT + 50 * i)));
		}
	}

	private void handleBirdAiming() {
		Bird.BirdState birdState = bird.getState();

		if(birdState == Bird.BirdState.init && Gdx.input.justTouched()) {
			bird.setState(Bird.BirdState.aim);
		}

		if(birdState == Bird.BirdState.aim && Gdx.input.isTouched()) {
			bird.setPosition(bird.getX() + Gdx.input.getDeltaX(), bird.getY() - Gdx.input.getDeltaY());
		}

		if(birdState == Bird.BirdState.aim && !Gdx.input.isTouched()) {
			bird.setState(Bird.BirdState.fly);
		}
	}

	private void update() {
		float dt = Gdx.graphics.getDeltaTime();
		handleBirdAiming();

		bird.accelerate(dt);
		bird.move(dt);

		wasp.accelerate(dt);
		wasp.move(dt);
	}

	@Override
	public void render () {
		update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);

		bird.draw(batch);
		wasp.draw(batch);
		scenery.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
