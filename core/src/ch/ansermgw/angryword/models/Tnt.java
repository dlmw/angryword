package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Tnt extends PhysicalObject {
    private static final String SPRITE_NAME = "tnt.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public Tnt(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME);
    }
}
