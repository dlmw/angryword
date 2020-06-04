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
    private static final int FLOOR_START = 10*BLOCK_SIZE;

    private ArrayList<PhysicalObject> scene;

    public Scenery() {
        scene = new ArrayList<PhysicalObject>();
    }

    public void addElement(PhysicalObject el) {
        scene.add(el);
    }

    public void addFloor() {
        for (int i = 0; i < (AngrywordMain.WORLD_WIDTH - FLOOR_START) / BLOCK_SIZE; i++) {
            addElement(new Block(new Vector2(FLOOR_START + i * BLOCK_SIZE, AngrywordMain.FLOOR_HEIGHT)));
        }

        addElement(new Slingshot(new Vector2( AngrywordMain.BIRD_SPAWN.x-25, AngrywordMain.BIRD_SPAWN.y-225)));
    }

    public void addPig() {
        int pigCount = 0;

        while (pigCount < 5){
            Vector2 randomPos = new Vector2(
                    FLOOR_START+AngrywordMain.rand.nextInt(AngrywordMain.WORLD_WIDTH-FLOOR_START),
                    AngrywordMain.FLOOR_HEIGHT + 60
            );

            try {
                checkColliding(randomPos, Pig.WIDTH, Pig.HEIGHT);
                addElement(new Pig(randomPos));
                pigCount++;
            } catch (Exception e) {
                System.out.println("One pig collided");
            }


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

    private void checkColliding(Vector2 position, int width, int height) throws Exception {
        for (PhysicalObject element : scene) {
            // THIS IS SOME HORRIBLE CODE REQUIRED FOR DEMO :(
            if (element.isHittingHitbox(position) || element.isHittingHitbox(new Vector2(position.x + width, position.y + height))) {
                throw new Exception("Sorry");
            }
        }
    }
}
