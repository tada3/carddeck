package trump;

public enum Rank {
    JOKER(0, "Joker"), ACE(1, "Ace"), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King");

    private final int value;
    private final String name;

    private Rank(int v) {
       this(v, null);
    }

    private Rank(int v, String n) {
        value = v;
        name = n;
    }
    
    public int value() {
        return value;
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        }
        return Integer.toString(value);

    } 
}