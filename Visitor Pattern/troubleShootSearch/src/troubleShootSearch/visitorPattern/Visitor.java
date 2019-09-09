package troubleShootSearch.visitorPattern;

import java.util.List;

/*
 * @author Munjal Shah
 */
public interface Visitor {

    public List visit(ExactMatch exactMatch);

    public List visit(NaiveStemmingMatch naiveStemmingMatch);

    public List visit(SemanticMatch semanticMatch);

}
