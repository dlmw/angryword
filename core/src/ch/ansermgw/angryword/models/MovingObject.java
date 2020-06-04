package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public abstract class MovingObject extends PhysicalObject {
    protected final static float Gravity = -50;

    protected Vector2 speed;
    private boolean frozen;

    public MovingObject(Vector2 position, float width, float height, String spriteName, Vector2 speed) {
        super(position, width, height, spriteName);
        this.speed = speed;
    }

    public void move(float dt) {
        translate(speed.x * dt, speed.y * dt);
    }

    public abstract void accelerate(float dt);

    protected void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    protected boolean isFrozen() {
        return frozen;
    }
}
