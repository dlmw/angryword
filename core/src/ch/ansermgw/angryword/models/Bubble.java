package ch.ansermgw.angryword.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.resource.WordResource;

public class Bubble extends TextualObject {
    public static final int WIDTH = 75 * 2;
    public static final int HEIGHT = 65 * 2;
    private static final String SPRITE_NAME = "bubble.png";
    private BitmapFont font;
    private GlyphLayout glyphLayout;

    public Bubble(Vector2 position, WordResource word) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, word);
        font = new BitmapFont();
        font.getData().setScale(2f);
        font.setColor(Color.BLACK);
        glyphLayout = new GlyphLayout(font, word.getTranslation());
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        font.draw(batch, glyphLayout, getX() + (getWidth() - glyphLayout.width) / 2, getY() + (getHeight() + glyphLayout.height * 2) / 2);
    }
}
