package info.jayharris.cardgames;

/**
 * Created by jayharris on 5/27/15.
 */
public enum Rank {
    ACE(14, "A"),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10, "T"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K");

    protected final int value;
    protected final String str;

    Rank(int value) {
        this(value, String.valueOf(value));
    }

    Rank(int value, String str) {
        this.value = value;
        this.str   = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
