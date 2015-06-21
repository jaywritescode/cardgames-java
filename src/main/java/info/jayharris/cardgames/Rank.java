package info.jayharris.cardgames;

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

    public final int value;
    public final String str;

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

    public enum SortType { ACE_LOW, ACE_HIGH }

    public Rank lower() {
        return lower(null);
    }

    public Rank lower(SortType sortType) {
        switch (this) {
            case ACE:
                return sortType != SortType.ACE_LOW ? KING : null;
            case KING:
                return QUEEN;
            case QUEEN:
                return JACK;
            case JACK:
                return TEN;
            case TEN:
                return NINE;
            case NINE:
                return EIGHT;
            case EIGHT:
                return SEVEN;
            case SEVEN:
                return SIX;
            case SIX:
                return FIVE;
            case FIVE:
                return FOUR;
            case FOUR:
                return THREE;
            case THREE:
                return TWO;
            case TWO:
                return sortType != SortType.ACE_HIGH ? ACE : null;
            default:
                return null;
        }
    }

    public Rank higher() {
        return higher(null);
    }

    public Rank higher(Rank.SortType sortType) {
        switch (this) {
            case ACE:
                return sortType != SortType.ACE_HIGH ? TWO : null;
            case KING:
                return sortType != SortType.ACE_LOW ? ACE : null;
            case QUEEN:
                return KING;
            case JACK:
                return QUEEN;
            case TEN:
                return JACK;
            case NINE:
                return TEN;
            case EIGHT:
                return NINE;
            case SEVEN:
                return EIGHT;
            case SIX:
                return SEVEN;
            case FIVE:
                return SIX;
            case FOUR:
                return FIVE;
            case THREE:
                return FOUR;
            case TWO:
                return THREE;
            default:
                return null;
        }
    }
}
