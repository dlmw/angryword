package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class TextualObject extends PhysicalObject {
    private String word;

    public TextualObject(Vector2 position, float width, float height, String spriteName) {
        super(position, width, height, spriteName);
    }

    protected String getWord() {
        return word;
    }
}
