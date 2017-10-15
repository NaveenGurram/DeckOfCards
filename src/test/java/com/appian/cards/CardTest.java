package com.appian.cards;

import com.appian.cards.Card;
import com.appian.cards.Rank;
import com.appian.cards.Suit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.*;

/**
 * Created by Naveen on 10/15/17.
 * Test class {@link com.appian.cards.Card}
 */
@RunWith(JUnit4.class)
public class CardTest {

    @Before
    public void init() {

    }

    @Test
    public void testHappyCase() {
        Card card = new Card(Suit.CLUBS, Rank.ACE);
        assertNotNull(card);
        assertEquals(Suit.CLUBS, card.getSuit());
        assertEquals(Rank.ACE, card.getRank());
        assertEquals("CLUBS ACE", card.toString());
    }

    @Test
    public void testCompare() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.CLUBS, Rank.ACE);
        assertNotNull(card1);
        assertNotNull(card2);
        assertTrue(card1.compareTo(card2) == 0);
        card2 = new Card(Suit.DIAMONDS, Rank.ACE);
        assertNotSame(card1.compareTo(card2), 0);
        card2 = new Card(Suit.CLUBS, Rank.EIGHT);
        assertNotSame(card1.compareTo(card2), 0);
        assertFalse(card1.equals(null));
        assertFalse(card1.equals(new Object()));
        assertTrue(card1.equals(card1));
        assertNotSame(card1.hashCode(), card2.hashCode());
        card1 = new Card(Suit.CLUBS, Rank.FIVE);
        card2 = new Card(Suit.CLUBS, Rank.EIGHT);
        assertNotSame(card1.compareTo(card2), 0);
    }

    @Test
    public void testEquals() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.CLUBS, Rank.ACE);
        assertNotNull(card1);
        assertNotNull(card2);
        assertTrue(card1.equals(card2));
        card2 = new Card(Suit.DIAMONDS, Rank.ACE);
        assertFalse(card1.equals(card2));
        card2 = new Card(Suit.CLUBS, Rank.EIGHT);
        assertFalse(card1.equals(card2));
    }


}
