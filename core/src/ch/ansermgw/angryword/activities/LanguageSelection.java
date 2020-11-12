package ch.ansermgw.angryword.activities;

import java.util.List;

import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.provider.LanguageProvider;

public class LanguageSelection extends Activity {
    private List<Language> sourceLanguages;
    private List<Language> targetLanguages;

    @Override
    public void create() {
        super.create();
        sourceLanguages = LanguageProvider.getInstance().getLanguages();
        targetLanguages = LanguageProvider.getInstance().getLanguages();
    }

    @Override
    public void render() {
        super.render();
        // TODO loop over languages and display a button accordingly
        super.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
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
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
