package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.resource.WordResource;

public class Panel extends TextualObject {
    public static final int WIDTH = 510/2;
    public static final int HEIGHT = 486/2;
    private static final String SPRITE_NAME = "panel.png";

    public Panel(Vector2 position, WordResource word) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, word.getWord(), new Vector2(0, -Math.abs(HEIGHT/4)));
    }
}