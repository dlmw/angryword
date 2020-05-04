package ch.ansermgw.angryword.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Bird extends MovingObject {
    private static String TextureName = "bird.png";

    public Bird(int srcX, int srcY) {
        super(new Texture(Bird.TextureName), srcX, srcY, new Vector2(2, 2));
    }

    @Override
    public void accelerate(Float dt) {

    }
}
