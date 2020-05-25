package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Pig extends TextualObject {

    private static final String SPRITE_NAME = "pig.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Pig(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME);
    }
}
