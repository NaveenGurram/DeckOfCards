package com.appian.cards;

import com.appian.cards.Card;
import com.appian.cards.Deck;
import com.appian.cards.Rank;
import com.appian.cards.Suit;
import com.appian.cards.exception.EmptyDeckException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Naveen on 10/15/17.
 * Test class for {@link com.appian.cards.Deck}
 */
@RunWith(JUnit4.class)
public class DeckTest {
    Deck deck;

    @Before
    public void init(){
        deck = new Deck();
    }

    @Test
    public void testHappyCase() {
        // verify size is 52
        assertEquals(52, deck.size());
        testNoDups();
    }

    @Test
    public void testBeforeShuffle() {
        // verify size is 52
        assertEquals(52, deck.size());
        // before shuffle first card will be spade ace
        assertEquals(new Card(Suit.SPADES, Rank.ACE), deck.draw());
    }

    @Test
    public void testShuffle() {
        // verify size is 52
        assertEquals(52, deck.size());
        deck.shuffle();
        testNoDups();
    }

    @Test(expected = EmptyDeckException.class)
    public void testEmptyDeckException() {
        // verify size is 52
        assertEquals(52, deck.size());
        deck.shuffle();
        testNoDups();
        // this draw should throw a exception
        deck.draw();
    }

    private void testNoDups(){
        List<Card> drawedCards = new ArrayList<>();
        Card drawedCard = null;
        while(deck.size() > 0){
            drawedCard = deck.draw();
            assertFalse(drawedCards.contains(drawedCard));
            drawedCards.add(drawedCard);
        }
    }
}
