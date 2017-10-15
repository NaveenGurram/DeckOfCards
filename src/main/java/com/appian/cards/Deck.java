package com.appian.cards;

import com.appian.cards.exception.EmptyDeckException;

import java.util.Random;
import java.util.Stack;

/**
 * Created by Naveen on 10/14/17.
 * Deck class representing deck of 52 cards made of {@link Card card}
 *
 */
public class Deck {

    private Stack<Card> deck = new Stack<Card>();

    /**
     *  Deck constructor
     */
    public Deck(){
        for (Suit suit: Suit.values()){
            for (Rank rank : Rank.values()){
                deck.push(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffle method to shuffle cards in the deck.
     */
    public void shuffle(){
        Random random = new Random();
        int n = deck.size();
        while (n > 1) {
            int k = random.nextInt(n--); //decrements after using the value
            Card temp = deck.get(n);
            deck.set(n, deck.get(k));
            deck.set(k, temp);
        }
    }

    /**
     * Draw top most card.
     * @return
     * @throws EmptyDeckException
     */
    public Card draw() throws EmptyDeckException {
        if (deck.size() > 0){
            return deck.pop();
        } else {
            throw new EmptyDeckException("No more cards to deal!");
        }
    }

    /**
     * size of the deck
     * @return
     */
    public int size(){
        return deck.size();
    }
}
