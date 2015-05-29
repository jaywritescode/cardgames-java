package info.jayharris.cardgames;

/**
 * Created by jayharris on 5/27/15.
 */
public enum Suit {
    CLUBS(Color.BLACK), DIAMONDS(Color.RED), SPADES(Color.BLACK), HEARTS(Color.BLACK);

    enum Color {
        RED, BLACK;

        public Color opposite() {
            return this == Color.RED ? Color.BLACK : Color.RED;
        }
    }

    public final Color color;

    Suit(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.name().substring(0,1);
    }
}
