package trump;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck<T extends Card> {

    private final CardFactory<T> cardFactory;
    private final int numOfJokers;
    private final LinkedList<T> cards;
    private final List<T> dealtCards;

    public Deck(CardFactory<T> cf) {
        this(cf, 0);
    }

    public Deck(CardFactory<T> cf, int noj) {
        cardFactory = cf;
        numOfJokers = noj;

        cards = new LinkedList<T>();
        dealtCards = new ArrayList<T>();

        for (Suit s : Suit.values()) {
            if (s == Suit.JOKER) {
                continue;
            }
            for (Rank r : Rank.values()) {
                if (r == Rank.JOKER) {
                    continue;
                }
                T c = cardFactory.create(s, r);
                cards.add(c);
            }
        }
        // Joker
        for (int i = 0; i < numOfJokers; i++) {
            cards.add(cardFactory.create(Suit.JOKER, Rank.JOKER));
            cards.add(cardFactory.create(Suit.JOKER, Rank.JOKER));
        }
    }

    public int reaminingCards() {
        return cards.size();
    }

    public T dealOne() {
        if (cards.isEmpty()) {
            return null;
        }
        T c = cards.remove();
        dealtCards.add(c);
        return c;
    }

    public List<T> deal(int n) {
        List<T> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            var c = dealOne();
            if (c == null) {
                break;
            }
            ret.add(c);
        }
        return ret;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}