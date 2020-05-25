package ch.ansermgw.angryword.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.AngrywordMain;

public class Bird extends MovingObject {
    private enum BirdState { init, aim, fly }

    private static final String SPRITE_NAME = "bird.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private BirdState state = BirdState.init;

    public Bird(Vector2 position, Vector2 speed) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, speed);
    }

    @Override
    public void accelerate(float dt) {
        speed.y += MovingObject.Gravity * dt;
    }
}
