package trump;

public class Card {
    private final Suit suit;
    private final Rank rank;    

    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }
    
    public Suit suit() {
        return suit;
    }

    public Rank rank() {
        return rank;
    }

    public int value() {
        return rank().value();
    }

    public String name() {
        if (suit == Suit.JOKER) {
            return suit.toString();
        }
        return String.format("%s of %s", rank, suit);
    }
}