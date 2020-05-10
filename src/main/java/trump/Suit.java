package trump;

public enum Suit {
    CLUBS("Clubs"), 
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades"),
    JOKER("Joker");

    private final String name;

    private Suit(String n) {
        name = n;
    }

    @Override
    public String toString() {
        return name;
    }
}