package ch.ansermgw.angryword.models;

import java.util.HashMap;
import java.util.Map;

public class SemanticWord {
    private final Map<Language, String> values;

    public SemanticWord() {
        this.values = new HashMap<>();
    }

    public void addTranslation(Language language, String value) {
        this.values.put(language, value);
    }

    public String getValue(Language language) {
        return values.get(language);
    }
}
