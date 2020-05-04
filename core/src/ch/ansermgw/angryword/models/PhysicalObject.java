package ch.ansermgw.angryword.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PhysicalObject extends Sprite {
    public PhysicalObject(Texture texture, int srcX, int srcY) {
        super(texture, srcX, srcY, texture.getWidth(), texture.getHeight());
    }
}
