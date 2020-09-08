package ch.ansermgw.angryword.provider;


import java.util.ArrayList;
import java.util.List;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.resource.VocabularyResource;
import ch.ansermgw.angryword.resource.WordResource;

public class VocabularyProvider {
    private static VocabularyProvider instance;
    private List<VocabularyResource> vocabularies;

    private VocabularyProvider() {
        vocabularies = new ArrayList<>();

        VocabularyResource voc = new VocabularyResource("French - English T1");
        WordResource word;

        word = new WordResource("Bonjour", "Hello"); voc.addWord(word);
        word = new WordResource("Manger", "to Eat"); voc.addWord(word);
        word = new WordResource("Vendre", "to Sell"); voc.addWord(word);
        word = new WordResource("Acheter", "to Buy"); voc.addWord(word);
        word = new WordResource("Voler", "to Fly"); voc.addWord(word);
        word = new WordResource("Avion", "Plane"); voc.addWord(word);

       vocabularies.add(voc);
    }

    public static VocabularyProvider getInstance() {
        if (instance == null)
            VocabularyProvider.instance = new VocabularyProvider();

        return instance;
    }

    public VocabularyResource getRandomVocabulary() {
        return vocabularies.get(AngrywordMain.rand.nextInt(vocabularies.size()));
    }
}
