package ch.ansermgw.angryword.models;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import static ch.ansermgw.angryword.AngrywordMain.FLOOR_HEIGHT;

public class Bird extends MovingObject implements InputProcessor {
    public static enum BirdState { init, aim, fly }

    private static final String SPRITE_NAME = "bird.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private Vector2 initialPos;
    private BirdState state = BirdState.init;
    private OrthographicCamera camera;

    public Bird(Vector2 position, OrthographicCamera camera) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, new Vector2(0,0));
        this.camera = camera;
        this.initialPos = position;
    }

    @Override
    public void accelerate(float dt) {
        speed.y += MovingObject.Gravity * dt * 2;
    }

    @Override
    public void move(float dt) {
        if(state == BirdState.fly) {
            if (getY() < 0) {
                this.reset();
                return;
            }

            super.move(dt);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (state == BirdState.init && isHittingHitbox(getAbsolutePosition(screenX, screenY))) {
            state = BirdState.aim;
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(state == BirdState.aim)
        {
            Vector2 pos = getAbsolutePosition(screenX, screenY);

            state = BirdState.fly;
            speed = new Vector2(initialPos.x - pos.x, initialPos.y - pos.y).scl(3);
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (state == BirdState.aim) {
            Vector2 pos = limitPositionToShootingZone(getAbsolutePosition(screenX, screenY));

            setPosition(pos.x, pos.y);
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

    private Vector2 getAbsolutePosition(int x, int y) {
        Vector3 pos = camera.unproject(new Vector3(x, y, 0));
        return new Vector2(pos.x, pos.y);
    }

    private Vector2 limitPositionToShootingZone(Vector2 position)
    {
        return new Vector2(
                Math.min( Math.max(0, position.x), initialPos.x),
                Math.min( Math.max(FLOOR_HEIGHT, position.y), initialPos.y)
        );
    }

    private void reset() {
        state = BirdState.init;
        setPosition(initialPos.x, initialPos.y);
        speed = new Vector2(0, 0);
    }
}
