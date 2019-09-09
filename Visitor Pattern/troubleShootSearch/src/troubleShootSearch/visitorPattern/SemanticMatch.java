package troubleShootSearch.visitorPattern;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import troubleShootSearch.util.MyLogger;

/*
 * @author Munjal Shah
 */
public class SemanticMatch implements Visitable {

    String keyWord;
    List<String> technicalSentences;
    Map<String, String> synonym;

    /**
     * Constructor of SemanticMatch
     *
     * @param keyWord
     * @param technicalSentences
     * @param synonym
     */
    public SemanticMatch(String keyWord, List<String> technicalSentences, Map<String, String> synonym) {
        this.keyWord = keyWord;
        this.technicalSentences = technicalSentences;
        this.synonym = synonym;
    }

    /**
     * This method has logic to search a keyword
     *
     * @return
     */
    public List search() {
        List<String> list = new LinkedList<>();
        String key = keyWord.substring(keyWord.lastIndexOf(" ") + 1);
        String word;
        boolean exist = synonym.containsValue(key);
        if (exist) {
            word = getKey(synonym, key);
        } else {
            word = synonym.get(key);
        }
        for (String sentence : technicalSentences) {
            if (word != null) {
                if (sentence.contains(word)) {
                    MyLogger.writeMessage("Adding sentence to list of Semantic Match", MyLogger.DebugLevel.SemanticMatch);
                    list.add(sentence);
                }
            }
        }
        return list;
    }

    /**
     * This method returns key form value
     *
     * @param <K>
     * @param <V>
     * @param map
     * @param value
     * @return
     */
    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public List accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
