package troubleShootSearch.visitorPattern;

import java.util.LinkedList;
import java.util.List;
import troubleShootSearch.util.MyLogger;

/*
 * @author Munjal Shah
 */
public class DSeGate implements Visitor {

    List<String> list = new LinkedList<>();

    @Override
    public List visit(ExactMatch exactMatch) {
        MyLogger.writeMessage("Searching for Excat Match", MyLogger.DebugLevel.DSeaGate);
        list = exactMatch.search();
        return list;
    }

    @Override
    public List visit(NaiveStemmingMatch naiveStemmingMatch) {
        MyLogger.writeMessage("Searching for Naive Stemming Match", MyLogger.DebugLevel.DSeaGate);
        list = naiveStemmingMatch.search();
        return list;
    }

    @Override
    public List visit(SemanticMatch semanticMatch) {
        MyLogger.writeMessage("Searching for Semantic Match", MyLogger.DebugLevel.DSeaGate);
        list = semanticMatch.search();
        return list;
    }
}
