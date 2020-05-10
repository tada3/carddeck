package trump.blackjack;

import trump.Card;
import trump.Suit;
import trump.Rank;

public class BlackjackCard extends Card {

    public BlackjackCard(Suit s, Rank r) {
        super(s, r);
    }

    @Override
    public int value() {
        if (isFaceCard()) {
            return 10;
        }
        return rank().value();
    }

    public int softValue() {
        if (isAce()) {
            return 11;
        }
        return value();
    }

    public boolean isAce() {
        return rank() == Rank.ACE;
    }

    public boolean isFaceCard() {
        return rank().value() > 10;
    }
}