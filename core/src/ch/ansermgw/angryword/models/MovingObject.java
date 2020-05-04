package ch.ansermgw.angryword.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingObject extends PhysicalObject {
    private Vector2 Speed;

    public MovingObject(Texture texture, int srcX, int srcY, Vector2 speed) {
        super(texture, srcX, srcY);
        this.Speed = speed;
    }

    public void move(Float dt) {

    }

    public abstract void accelerate(Float dt);
}
