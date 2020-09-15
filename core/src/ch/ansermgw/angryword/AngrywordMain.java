package ch.ansermgw.angryword;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

import ch.ansermgw.angryword.models.Bird;
import ch.ansermgw.angryword.models.Bubble;
import ch.ansermgw.angryword.models.PhysicalObject;
import ch.ansermgw.angryword.models.Pig;
import ch.ansermgw.angryword.models.Slingshot;
import ch.ansermgw.angryword.models.Wasp;
import ch.ansermgw.angryword.provider.VocabularyProvider;
import ch.ansermgw.angryword.resource.VocabularyResource;

public class AngrywordMain extends Game implements InputProcessor {
    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;
    public static final int FLOOR_HEIGHT = 150;
    public static final Vector2 BIRD_SPAWN = new Vector2(200, FLOOR_HEIGHT + 200);
    private static final String BACKGROUND_NAME = "background.jpg";
    public static Random rand;
    private Texture background;
    private SpriteBatch batch;

    private Bird bird;
    private Wasp wasp;
    private Scenery scenery;
    private OrthographicCamera camera;
    private VocabularyResource vocabulary;
    private Bubble bubble;

    @Override
    public void create() {
        batch = new SpriteBatch();

        rand = new Random(System.currentTimeMillis());
        background = new Texture(BACKGROUND_NAME);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        vocabulary = VocabularyProvider.getInstance().getRandomVocabulary();

        scenery = new Scenery(vocabulary);
        scenery.addFloor();
        scenery.addPig();
        scenery.addTnt();

        bird = new Bird(BIRD_SPAWN);
        wasp = new Wasp(new Vector2(Math.abs(WORLD_WIDTH / 3), Math.abs(WORLD_HEIGHT / 2)));

        Gdx.input.setInputProcessor(this);
    }

    private void update() {
        float dt = Gdx.graphics.getDeltaTime();

        bird.accelerate(dt);
        bird.move(dt);
        handleBirdCollision();

        wasp.accelerate(dt);
        wasp.move(dt);
    }

    @Override
    public void render() {
        update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);

        bird.draw(batch);
        wasp.draw(batch);
        scenery.draw(batch);

        if (bubble != null)
            bubble.draw(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void handleBirdCollision() {
        if (bird.getState() != Bird.BirdState.fly) {
            return;
        }

        if (bird.isCollidingTo(wasp)) {
            bird.kill();
            return;
        }

        for (PhysicalObject element : scenery.getElements()) {
            if (!(element instanceof Slingshot) && bird.isCollidingTo(element)) {
                bird.kill();

                if (element instanceof Pig) {
                    scenery.removeElement(element);
                    bird.reset();
                }

                break;
            }


        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        bubble = null;

        if (bird.getState() == Bird.BirdState.init && isPhysicalObjectContainingVector(bird, getAbsolutePosition(screenX, screenY))) {
            bird.aim();
        }

        for (PhysicalObject physicalObject : scenery.getElements()) {
            if (physicalObject instanceof Pig && isPhysicalObjectContainingVector(physicalObject, getAbsolutePosition(screenX, screenY))) {
                bubble = new Bubble(
                        new Vector2(
                                physicalObject.getX() - physicalObject.getWidth(),
                                physicalObject.getY() + physicalObject.getHeight()
                        ),
                        ((Pig) physicalObject).getWord()
                );
            }
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (bird.getState() == Bird.BirdState.aim) {
            bird.release(getAbsolutePosition(screenX, screenY));
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (bird.getState() == Bird.BirdState.aim) {
            Vector2 pos = limitPositionToShootingZone(getAbsolutePosition(screenX, screenY));

            bird.setPosition(pos.x, pos.y);
        }

        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private boolean isPhysicalObjectContainingVector(PhysicalObject physicalObject, Vector2 vector) {
        return physicalObject.getBoundingRectangle().contains(vector);
    }

    private Vector2 getAbsolutePosition(int x, int y) {
        Vector3 pos = camera.unproject(new Vector3(x, y, 0));
        return new Vector2(pos.x, pos.y);
    }

    private Vector2 limitPositionToShootingZone(Vector2 position) {
        return new Vector2(
                Math.min(Math.max(0, position.x), BIRD_SPAWN.x),
                Math.min(Math.max(FLOOR_HEIGHT, position.y), BIRD_SPAWN.y)
        );
    }

}
