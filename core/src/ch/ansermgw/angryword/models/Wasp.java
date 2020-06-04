package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

import ch.ansermgw.angryword.AngrywordMain;


public class Wasp extends MovingObject {

    private static final int AGITATION = AngrywordMain.WORLD_WIDTH/3;
    private static final String SPRITE_NAME = "wasp.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Wasp(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, new Vector2(20, 20));
    }

    @Override
    public void accelerate(float dt) {
        Vector2 folly = new Vector2(
                AngrywordMain.rand.nextFloat() - getX()/AngrywordMain.WORLD_WIDTH,
                AngrywordMain.rand.nextFloat() - getY()/AngrywordMain.WORLD_HEIGHT
        );

        speed = speed.add(folly.scl(AGITATION * dt));
    }


}

