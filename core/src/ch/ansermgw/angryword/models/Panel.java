package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Panel extends TextualObject {
    public static final int WIDTH = 510 / 2;
    public static final int HEIGHT = 486 / 2;
    private static final String SPRITE_NAME = "panel.png";
    private SemanticWord semanticWord;

    public Panel(Vector2 position, SemanticWord word) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, word.getWord(), new Vector2(0, -Math.abs(HEIGHT / 4)));
        semanticWord = word;
    }

    public SemanticWord getWordResource() {
        return semanticWord;
    }

    public void setWordResource(SemanticWord wordResource) {
        this.semanticWord = wordResource;
        this.glyphLayout.setText(font, semanticWord.getValue(new Language("Français", "fr"))); // TODO get from current language
    }
}
