package ch.ansermgw.angryword.resource;

public class WordResource {
    private String word;
    private String translation;
    private boolean isUsed;

    public WordResource(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.isUsed = false;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
