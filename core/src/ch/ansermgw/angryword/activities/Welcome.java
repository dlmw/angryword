package ch.ansermgw.angryword.activities;

import ch.ansermgw.angryword.AngrywordMain;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static ch.ansermgw.angryword.activities.Play.WORLD_HEIGHT;
import static ch.ansermgw.angryword.activities.Play.WORLD_WIDTH;

public class Welcome extends Activity {
    private static final String BACKGROUND_NAME = "background.jpg";
    private Texture background;
    private SpriteBatch batch;
    private BitmapFont title;

    private OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();

        background = new Texture(BACKGROUND_NAME);

        title = new BitmapFont();
        title.setColor(Color.RED);
        title.getData().setScale(7);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(batch, "Hello", Math.abs(WORLD_WIDTH / 2), Math.abs(WORLD_HEIGHT / 2));
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Activity play = new Play();
        play.create();
        AngrywordMain.getInstance().push(play);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
