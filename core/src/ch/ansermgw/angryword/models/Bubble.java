package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.resource.WordResource;

public class Bubble extends TextualObject {
    public static final int WIDTH = 75 * 2;
    public static final int HEIGHT = 65 * 2;
    private static final String SPRITE_NAME = "bubble.png";

    public Bubble(Vector2 position, WordResource word) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, word.getTranslation());
    }
}
