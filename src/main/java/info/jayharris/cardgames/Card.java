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

    /**
     * Constructs a face-up card with the given rank and suit.
     *
     * @param rank the rank
     * @param suit the suit
     */
    public Card(Rank rank, Suit suit) {
        this(rank, suit, false);
    }

    /**
     * Constructs a card with the given rank, suit, and face-up-ed-ness.
     *
     * @param rank the rank
     * @param suit the suit
     * @param isFacedown {@code true} if the card is face-down
     */
    public Card(Rank rank, Suit suit, boolean isFacedown) {
        this.rank = rank;
        this.suit = suit;
        this.isFacedown = isFacedown;
    }

    /**
     * Gets this card's rank.
     *
     * @return this card's rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Gets this card's suit.
     *
     * @return this card's suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Gets this card's color (red or black).
     *
     * @return this card's color
     */
    public Suit.Color getColor() { return suit.color; }

    /**
     * Gets whether this card is face-down.
     *
     * @return {@code true} iff the card is face-down
     */
    public boolean isFacedown() {
        return isFacedown;
    }

    /**
     * Gets this card's rank, if this card is face-up (and therefore its rank
     * is known).
     *
     * @return this card's rank, or an absent {@code Optional} if this card is
     * face-down
     */
    public Optional<Rank> getRankIfVisible() {
        return Optional.fromNullable(isFacedown ? null : getRank());
    }

    /**
     * Gets this card's suit, if this card is face-up (and therefore its suit
     * is known).
     *
     * @return this card's suit, or an absent {@code Optional} if this card is
     * face-down
     */
    public Optional<Suit> getSuitIfVisible() {
        return Optional.fromNullable(isFacedown ? null : getSuit());
    }

    /**
     * Flips the card, making a face-down card face-up, and vice versa.
     */
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
     * Creates a card from a string, such as "2H" or "JS".
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

    /**
     * Creates a card with a randomly chosen rank and suit.
     *
     * @return a random card
     */
    public static Card randomCard() {
        Rank rank = EnumSet.allOf(Rank.class).toArray(new Rank[] {})[(int) (Math.random() * 13)];
        Suit suit = EnumSet.allOf(Suit.class).toArray(new Suit[] {})[(int) (Math.random() * 4)];
        return new Card(rank, suit);
    }
}
