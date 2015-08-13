package info.jayharris.cardgames;

public enum Suit {
    CLUBS(Color.BLACK), DIAMONDS(Color.RED), SPADES(Color.BLACK), HEARTS(Color.RED);

    public enum Color {
        RED, BLACK;

        /**
         * @return {@code Color.RED} if this is {@code Color.BLACK}, otherwise
         * {@code Color.BLACK}
         */
        public Color opposite() {
            return this == Color.RED ? Color.BLACK : Color.RED;
        }
    }

    public final Color color;

    Suit(Color color) {
        this.color = color;
    }

    /**
     * @return this suit's color
     */
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.name().substring(0,1);
    }
}
