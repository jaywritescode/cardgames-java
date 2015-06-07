package info.jayharris.cardgames;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    @Test
    public void testLower() {
        assertEquals(Rank.KING,  Rank.ACE.lower());
        assertEquals(Rank.QUEEN, Rank.KING.lower());
        assertEquals(Rank.JACK,  Rank.QUEEN.lower());
        assertEquals(Rank.TEN,   Rank.JACK.lower());
        assertEquals(Rank.NINE,  Rank.TEN.lower());
        assertEquals(Rank.EIGHT, Rank.NINE.lower());
        assertEquals(Rank.SEVEN, Rank.EIGHT.lower());
        assertEquals(Rank.SIX,   Rank.SEVEN.lower());
        assertEquals(Rank.FIVE,  Rank.SIX.lower());
        assertEquals(Rank.FOUR,  Rank.FIVE.lower());
        assertEquals(Rank.THREE, Rank.FOUR.lower());
        assertEquals(Rank.TWO,   Rank.THREE.lower());
        assertEquals(Rank.ACE,   Rank.TWO.lower());
    }

    @Test
    public void testLower_ACE_HIGH() {
        assertEquals(Rank.KING,  Rank.ACE.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.QUEEN, Rank.KING.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.JACK,  Rank.QUEEN.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.TEN,   Rank.JACK.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.NINE,  Rank.TEN.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.EIGHT, Rank.NINE.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.SEVEN, Rank.EIGHT.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.SIX,   Rank.SEVEN.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.FIVE,  Rank.SIX.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.FOUR,  Rank.FIVE.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.THREE, Rank.FOUR.lower(Rank.SortType.ACE_HIGH));
        assertEquals(Rank.TWO,   Rank.THREE.lower(Rank.SortType.ACE_HIGH));
        assertNull(Rank.TWO.lower(Rank.SortType.ACE_HIGH));
    }

    @Test
    public void testLower_ACE_LOW() {
        assertNull(Rank.ACE.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.QUEEN, Rank.KING.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.JACK,  Rank.QUEEN.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.TEN,   Rank.JACK.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.NINE,  Rank.TEN.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.EIGHT, Rank.NINE.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.SEVEN, Rank.EIGHT.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.SIX,   Rank.SEVEN.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.FIVE,  Rank.SIX.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.FOUR,  Rank.FIVE.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.THREE, Rank.FOUR.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.TWO,   Rank.THREE.lower(Rank.SortType.ACE_LOW));
        assertEquals(Rank.ACE,   Rank.TWO.lower(Rank.SortType.ACE_LOW));
    }
}