package troubleShootSearch.visitorPattern;

import java.util.List;

/*
 * @author Munjal Shah
 */
public interface Visitable {

    public List accept(Visitor visitor);
}
