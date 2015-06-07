package info.jayharris.cardgames;

import com.google.common.base.Optional;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by jayharris on 5/27/15.
 */
public class Card {

    private final Rank rank;
    private final Suit suit;
    private boolean isFacedown;

    public Card(Rank rank, Suit suit) {
        this(rank, suit, false);
    }

    public Card(Rank rank, Suit suit, boolean isFacedown) {
        this.rank = rank;
        this.suit = suit;
        this.isFacedown = isFacedown;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Suit.Color getColor() { return suit.color; }

    public boolean isFacedown() {
        return isFacedown;
    }

    public Optional<Rank> getRankIfVisible() {
        return Optional.fromNullable(isFacedown ? null : getRank());
    }

    public Optional<Suit> getSuitIfVisible() {
        return Optional.fromNullable(isFacedown ? null : getSuit());
    }

    public void flip() {
        isFacedown = !isFacedown;
    }

    @Override
    public String toString() {
        return isFacedown ? "??" : new StringBuilder().append(rank).append(suit).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(rank, card.rank) &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    static Map<String, Rank> stringRankMap = new HashMap<String, Rank>() {{
        for (Rank rank : EnumSet.allOf(Rank.class)) {
            this.put(rank.toString(), rank);
        }
    }};

    static Map<String, Suit> stringSuitMap = new HashMap<String, Suit>() {{
        for (Suit suit : EnumSet.allOf(Suit.class)) {
            this.put(suit.toString(), suit);
        }
    }};

    /**
     * Create a card from a string, such as "2H" or "JS".
     *
     * @param string the input string
     * @return the appropriate card, face-up
     */
    public static Card fromString(String string) {
        checkArgument(string.length() == 2, "Cannot interpret input string.");
        String[] c = new String[] { String.valueOf(string.charAt(0)), String.valueOf(string.charAt(1)) };
        checkArgument(stringRankMap.containsKey(c[0]) && stringSuitMap.containsKey(c[1]),
                "Cannot interpret input string.");
        return new Card(stringRankMap.get(c[0]), stringSuitMap.get(c[1]));
    }
}
