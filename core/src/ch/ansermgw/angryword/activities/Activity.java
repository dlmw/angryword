package ch.ansermgw.angryword.activities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static ch.ansermgw.angryword.activities.Play.WORLD_HEIGHT;
import static ch.ansermgw.angryword.activities.Play.WORLD_WIDTH;

public abstract class Activity extends Game implements InputProcessor {
    protected static final String BACKGROUND_NAME = "background.jpg";
    protected Texture background;
    protected SpriteBatch batch;
    protected OrthographicCamera camera;


    @Override
    public void create() {
        batch = new SpriteBatch();

        background = new Texture(BACKGROUND_NAME);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    //Do not forget to call batch.end(); !
    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
