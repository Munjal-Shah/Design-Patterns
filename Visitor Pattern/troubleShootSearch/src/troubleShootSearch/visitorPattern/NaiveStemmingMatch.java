package troubleShootSearch.visitorPattern;

import java.util.LinkedList;
import java.util.List;
import troubleShootSearch.util.MyLogger;

/*
 * @author Munjal Shah
 */
public class NaiveStemmingMatch implements Visitable {

    String keyWord;
    List<String> technicalSentences;

    /**
     * Constructor for NiaveStemmingMatch
     *
     * @param keyWord
     * @param technicalSentences
     */
    public NaiveStemmingMatch(String keyWord, List<String> technicalSentences) {
        this.keyWord = keyWord;
        this.technicalSentences = technicalSentences;
    }

    /**
     * This method has logic to search a keyword
     *
     * @return
     */
    public List search() {
        List<String> list = new LinkedList<>();
        String key = keyWord.substring(0, keyWord.indexOf(" "));
        for (String sentence : technicalSentences) {
            if (sentence.contains(key)) {
                MyLogger.writeMessage("Adding sentence to list of Naive Stemming Match", MyLogger.DebugLevel.NaiveStemmingMatch);
                list.add(sentence);
            }
        }

        return list;
    }

    @Override
    public List accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
