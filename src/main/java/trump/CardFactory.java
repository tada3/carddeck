package trump;

import java.lang.reflect.InvocationTargetException;

public class CardFactory<T extends Card> {

    private Class<T> type;

    public CardFactory(Class<T> t) {
        type = t;
    }

    public T create(Suit suit, Rank rank) {
        try {
            return type.getDeclaredConstructor(Suit.class, Rank.class).newInstance(suit, rank);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new AssertionError("Cannot create an instance of " + type.getName(), e);
        }
    }
    
}