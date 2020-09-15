package ch.ansermgw.angryword.resource;

import java.util.ArrayList;
import java.util.List;

import ch.ansermgw.angryword.AngrywordMain;

public class VocabularyResource {
    private List<WordResource> words;
    private String name;

    public VocabularyResource(ArrayList<WordResource> words, String name) {
        this.words = words;
        this.name = name;
    }

    public VocabularyResource(String name) {
        words = new ArrayList<>();
        this.name = name;
    }

    public void addWord(WordResource word) {
        words.add(word);
    }

    public WordResource getRandomUnusedWordResource() {
        List<WordResource> unusedWord = new ArrayList<>();

        for (WordResource word : words) {
            if (!word.isUsed()) {
                unusedWord.add(word);
            }
        }

        return unusedWord.get(AngrywordMain.rand.nextInt(unusedWord.size()));
    }
}
