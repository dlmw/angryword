package ch.ansermgw.angryword;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.ansermgw.angryword.models.Block;
import ch.ansermgw.angryword.models.PhysicalObject;
import ch.ansermgw.angryword.models.Pig;
import ch.ansermgw.angryword.models.Slingshot;
import ch.ansermgw.angryword.models.Tnt;

public class Scenery {
    public static final int BLOCK_SIZE = 50;

    private ArrayList<PhysicalObject> scene;

    public Scenery() {
        scene = new ArrayList<PhysicalObject>();
    }

    public void addElement(PhysicalObject el) {
        scene.add(el);
    }

    public void addFloor() {
        for (int i = 10; i < AngrywordMain.WORLD_WIDTH / BLOCK_SIZE; i++) {
            addElement(new Block(new Vector2(i * BLOCK_SIZE, AngrywordMain.FLOOR_HEIGHT)));
        }

        addElement(new Slingshot(new Vector2( AngrywordMain.BIRD_SPAWN.x-25, AngrywordMain.BIRD_SPAWN.y-225)));
    }

    public void addPig() {
        for (int i = 10; i < 13; i++) {
            addElement(new Pig(new Vector2(i * 60, AngrywordMain.FLOOR_HEIGHT + 50)));
        }
    }

    public void addTnt() {
        for (int i = 1; i < 5; i++) {
            addElement(new Tnt(new Vector2(Math.abs(AngrywordMain.WORLD_WIDTH/4*3), AngrywordMain.FLOOR_HEIGHT + 50 * i)));
        }
    }

    public void draw(Batch batch) {
        for (PhysicalObject p : scene) p.draw(batch);
    }
}
