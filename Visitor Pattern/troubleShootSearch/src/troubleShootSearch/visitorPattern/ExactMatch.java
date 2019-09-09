package troubleShootSearch.visitorPattern;

import java.util.LinkedList;
import java.util.List;
import troubleShootSearch.util.MyLogger;

/*
 * @author Munjal Shah
 */
public class ExactMatch implements Visitable {

    String keyWord;
    List<String> technicalSentences;

    /**
     * Constructor for ExcatMatch
     *
     * @param keyWord
     * @param technicalSentences
     */
    public ExactMatch(String keyWord, List<String> technicalSentences) {
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
        for (String sentence : technicalSentences) {
            if (sentence.contains(keyWord)) {
                MyLogger.writeMessage("Adding sentence to list of Excat Match", MyLogger.DebugLevel.ExcatMatch);
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
