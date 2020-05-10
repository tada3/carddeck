package trump.blackjack;

import trump.Hand;

public class BlackjackHand extends Hand<BlackjackCard> {

    @Override
    public int value() {
        int vh = getHardValue();
        int vs = getSoftValue();
        if (vh > 21) {
            return 0;
        }
        if (vs > 21) {
            return vh;
        }
        return vs;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && value() == 21;
    }

    public boolean isBusted() {
        return value() == 0;
    }

    private int getHardValue() {
        return cards.stream().map(c -> c.value()).reduce(0, (x, y) -> x + y);
    }

    private int getSoftValue() {
        int v = 0;
        boolean usedSoft = false;
        for (BlackjackCard c : cards) {
            if (c.isAce() && !usedSoft) {
                usedSoft = true;
                v += c.softValue();
            } else {
                v += c.value();
            }
        }
        return v;
    }

}