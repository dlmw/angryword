package ch.ansermgw.angryword.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.AngrywordMain;

public class Bird extends MovingObject {
    public static enum BirdState { init, aim, fly }

    private static final String SPRITE_NAME = "bird.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private BirdState state = BirdState.init;

    public Bird(Vector2 position, Vector2 speed) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, speed);
    }

    public void handleInput() {
        Input input = Gdx.input;

        if(state == BirdState.init && input.justTouched()) {
            state = BirdState.aim;
        }

        if(state == BirdState.aim && input.isTouched()) {
            setPosition(getX() + input.getDeltaX(), getY() - input.getDeltaY());
        }

        if(state == BirdState.aim && !input.isTouched()) {
             state = BirdState.fly;
        }
    }

    @Override
    public void accelerate(float dt) {
        speed.y += MovingObject.Gravity * dt;
    }

    @Override
    public void move(float dt) {
        if(state == BirdState.fly) {
            super.move(dt);
        }
    }
}
