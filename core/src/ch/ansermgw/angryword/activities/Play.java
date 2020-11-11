package ch.ansermgw.angryword.activities;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.models.*;
import ch.ansermgw.angryword.provider.VocabularyProvider;
import ch.ansermgw.angryword.resource.VocabularyResource;
import ch.ansermgw.angryword.resource.WordResource;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Play extends Activity {
    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;
    public static final int FLOOR_HEIGHT = 150;
    public static final Vector2 BIRD_SPAWN = new Vector2(200, FLOOR_HEIGHT + 200);
    public static Random rand;


    private Bird bird;
    private Wasp wasp;
    private Scenery scenery;
    private VocabularyResource vocabulary;
    private Bubble bubble;
    private Panel panel;

    @Override
    public void create() {
        super.create();

        rand = new Random(System.currentTimeMillis());
        vocabulary = VocabularyProvider.getInstance().getRandomVocabulary();

        scenery = new Scenery(vocabulary);
        scenery.addFloor();
        scenery.addTnt();
        scenery.addPig();

        bird = new Bird(BIRD_SPAWN);
        wasp = new Wasp(new Vector2(Math.abs(WORLD_WIDTH / 3), Math.abs(WORLD_HEIGHT / 2)));

        panel = new Panel(new Vector2(Math.abs(WORLD_WIDTH / 15), WORLD_HEIGHT - Panel.HEIGHT), vocabulary.getRandomUsedWordResource());
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
        super.render();
        update();

        bird.draw(super.batch);
        wasp.draw(super.batch);
        scenery.draw(super.batch);
        panel.draw(super.batch);

        if (bubble != null)
            bubble.draw(super.batch);

        super.batch.end();
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
                    Pig pig = ((Pig) element);
                    pig.kill();

                    WordResource wordResource = vocabulary.getRandomUsedWordResource();

                    if (panel.getWordResource().equals(pig.getWord()) && wordResource != null) {
                        this.panel.setWordResource(wordResource);
                    } else {
                        AngrywordMain.getInstance().pop();
                    }

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
        Vector3 pos = super.camera.unproject(new Vector3(x, y, 0));
        return new Vector2(pos.x, pos.y);
    }

    private Vector2 limitPositionToShootingZone(Vector2 position) {
        return new Vector2(
                Math.min(Math.max(0, position.x), BIRD_SPAWN.x),
                Math.min(Math.max(FLOOR_HEIGHT, position.y), BIRD_SPAWN.y)
        );
    }
}
