package trump;

import java.util.List;
import java.util.ArrayList;

public class Hand<T extends Card> {

    protected List<T> cards;

    public Hand() {
        cards = new ArrayList<T>();
    }

    public Hand(List<T> cs) {
        cards = cs;
    }

    public void addCard(T c) {
        cards.add(c);
    }

    public int value() {
        return cards.stream().map(c -> c.value()).reduce(0, (x, y) -> x + y);
    }
}