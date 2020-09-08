package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.resource.WordResource;

public class TextualObject extends PhysicalObject {
    private WordResource word;

    public TextualObject(Vector2 position, float width, float height, String spriteName, WordResource word) {
        super(position, width, height, spriteName);
        this.word = word;
    }

    protected WordResource getWord() {
        return word;
    }
}
