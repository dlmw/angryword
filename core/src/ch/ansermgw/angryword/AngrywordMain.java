package ch.ansermgw.angryword;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import ch.ansermgw.angryword.models.Bird;
import ch.ansermgw.angryword.models.Wasp;

public class AngrywordMain extends Game {
	public static Random rand;

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
	public static final int FLOOR_HEIGHT = 150;
	public static final Vector2 BIRD_SPAWN = new Vector2(200, FLOOR_HEIGHT+200);

	private static final String BACKGROUND_NAME = "background.jpg";

	private Texture background;
	private SpriteBatch batch;

	private Bird bird;
	private Wasp wasp;
	private Scenery scenery;
	private OrthographicCamera camera;

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
		scenery.addPig();
		scenery.addTnt();

		this.bird = new Bird(BIRD_SPAWN, camera);
		this.wasp = new Wasp(new Vector2(Math.abs(WORLD_WIDTH/2), Math.abs(WORLD_HEIGHT/2)));

		Gdx.input.setInputProcessor(this.bird);
	}

	private void update() {
		float dt = Gdx.graphics.getDeltaTime();

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
