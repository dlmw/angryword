package ch.ansermgw.angryword.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.resource.WordResource;

public class Pig extends TextualObject {

    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    private static final String SPRITE_NAME = "pig.png";

    public Pig(Vector2 position, WordResource word) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, word);
    }

    public void touch() {
        Gdx.app.log("Pig", getWord().getWord());
    }
}
