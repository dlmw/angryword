package ch.ansermgw.angryword;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.ansermgw.angryword.models.Block;
import ch.ansermgw.angryword.models.PhysicalObject;

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
    }

    public void draw(Batch batch) {
        for (PhysicalObject p : scene) p.draw(batch);
    }
}
