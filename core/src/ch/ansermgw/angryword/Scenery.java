package ch.ansermgw.angryword;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.ansermgw.angryword.models.Block;
import ch.ansermgw.angryword.models.PhysicalObject;
import ch.ansermgw.angryword.models.Pig;
import ch.ansermgw.angryword.models.Slingshot;
import ch.ansermgw.angryword.models.Tnt;
import ch.ansermgw.angryword.resource.VocabularyResource;
import ch.ansermgw.angryword.resource.WordResource;

public class Scenery {
    private static int BLOCK_SIZE = 50;
    private ArrayList<PhysicalObject> elements;
    private VocabularyResource vocabulary;

    public Scenery(VocabularyResource vocabulary) {
        this.vocabulary = vocabulary;
        elements = new ArrayList<>();
    }

    public void addElement(PhysicalObject el) {
        elements.add(el);
    }

    public void removeElement(PhysicalObject el) {
        elements.remove(el);
    }

    public void addFloor() {
        for (int i = 0; i < 20; i++) {
            Vector2 position = generateRandomItemPosition();
            addElement(new Block(position));
        }

        addElement(new Slingshot(new Vector2(AngrywordMain.BIRD_SPAWN.x - 25, AngrywordMain.BIRD_SPAWN.y - 225)));
    }

    public ArrayList<PhysicalObject> getElements() {
        return elements;
    }

    public void addPig() {
        int pigCount = 0;

        while (pigCount < 3) {
            WordResource wordResource = vocabulary.getRandomUnusedWordResource();

            try {
                PhysicalObject element = elements.get(AngrywordMain.rand.nextInt(elements.size()));

                Vector2 position = generateRandomItemPosition(
                        Math.round(element.getX()),
                        Math.round(element.getY())
                );

                Pig pig = new Pig(position, wordResource);
                wordResource.setUsed(true);
                addElement(pig);
                pigCount++;
            } catch (Exception e) {
                System.out.println("One pig collided");
            }
        }
    }

    public void addTnt() {
        for (int i = 0; i < 10; i++) {
            Vector2 position = generateRandomItemPosition();
            addElement(new Tnt(position));
        }
    }

    private Vector2 generateRandomItemPosition() {
        Vector2 position = null;
        int startX = Math.round(AngrywordMain.BIRD_SPAWN.x) * 2;

        while (position == null) {
            try {
                int randomeX = startX + AngrywordMain.rand.nextInt(AngrywordMain.WORLD_WIDTH - startX - 100);
                int startY = AngrywordMain.FLOOR_HEIGHT;

                position = generateRandomItemPosition(randomeX, startY);
            } catch (Exception ignored) {
            }
        }

        return position;
    }

    private Vector2 generateRandomItemPosition(int x, int startY) throws Exception {
        for (PhysicalObject element : elements) {
            Rectangle rec = element.getBoundingRectangle();

            if (rec.overlaps(new Rectangle(x, startY, BLOCK_SIZE, BLOCK_SIZE))) {
                return generateRandomItemPosition(x, Math.round(rec.y + rec.height + 5));
            }
        }

        if (startY > AngrywordMain.WORLD_HEIGHT / 2) {
            throw new Exception("Space filled");
        }

        return new Vector2(x, startY);
    }

    public void draw(Batch batch) {
        for (PhysicalObject p : elements) p.draw(batch);
    }
}
