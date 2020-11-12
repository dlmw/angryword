package ch.ansermgw.angryword.activities;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.models.Button;
import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.provider.LanguageProvider;

public class LanguageSelection extends Activity {
    private List<Language> sourceLanguages;
    private List<Language> targetLanguages;

    private static final float SPACE_BETWEEN_BUTTONS = WORLD_HEIGHT / 8;

    private List<Button> sourceLanguagesButtons;
    private List<Button> targetLanguagesButtons;

    @Override
    public void create() {
        super.create();
        sourceLanguages = LanguageProvider.getInstance().getLanguages();
        targetLanguages = LanguageProvider.getInstance().getLanguages();

        sourceLanguagesButtons = createLanguagesButton(sourceLanguages, 200);
        targetLanguagesButtons = createLanguagesButton(targetLanguages, 400);

    }

    public List<Button> createLanguagesButton(List<Language> languages, float xPosition) {
        List<Button> buttons = new ArrayList<>();
        int loopIndex = 0;
        for (Language language : languages) {
            float yPosition = (loopIndex + 4) * SPACE_BETWEEN_BUTTONS;
            Vector2 buttonPosition = new Vector2(xPosition, yPosition);
            Button button = new Button(buttonPosition, language.getDisplayName());
            buttons.add(button);
            loopIndex++;
        }
        return buttons;
    }

    @Override
    public void render() {
        super.render();
        for (Button button : sourceLanguagesButtons) {
            button.draw(super.batch);
        }
        for (Button button : targetLanguagesButtons) {
            button.draw(super.batch);
        }
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
