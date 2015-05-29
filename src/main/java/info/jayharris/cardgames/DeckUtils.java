package info.jayharris.cardgames;

import java.util.EnumSet;
import java.util.LinkedList;

/**
 * Created by jayharris on 5/28/15.
 */
public class DeckUtils {

    /**
     * Create a standard 52-card deck.
     *
     * @return a standard deck of cards
     */
    public static Deck createStandardDeck() {
        return new Deck(new LinkedList<Card>() {{
            for (Suit suit : EnumSet.allOf(Suit.class)) {
                for (Rank rank : EnumSet.allOf(Rank.class)) {
                    this.add(new Card(rank, suit));
                }
            }
        }});
    }
}
