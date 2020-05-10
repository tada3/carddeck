/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trump;

import trump.blackjack.*;

public class App {

    public static void main(String[] args) {
        var cf = new CardFactory<>(BlackjackCard.class);
        var d = new Deck<>(cf);
        
        d.shuffle();

        System.out.printf("reamining cards: %d\n", d.reaminingCards());

        var h1 = new BlackjackHand();

        var c1 = d.dealOne();
        System.out.printf("c1: %s\n", c1.name());
        h1.addCard(c1);

        var c2 = d.dealOne();
        System.out.printf("c2: %s\n", c2.name());
        h1.addCard(c2);

        System.out.printf("value of h1: %d\n", h1.value());

        var h2 = new BlackjackHand();

        var c3 = d.deal(2);
        System.out.printf("c3: %s, %s\n", c3.get(0).name(), c3.get(1).name());
        c3.stream().forEach((c) -> h2.addCard(c));

        System.out.printf("value of h2: %d\n", h2.value());

        var c4 = d.deal(100);
        System.out.printf("size of c4: %d\n", c4.size());

        System.out.printf("reamining cards: %d\n", d.reaminingCards());
    }
}