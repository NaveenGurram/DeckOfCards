package com.appian.cards;

/**
 * Created by Naveen on 10/14/17.
 * Class representing Card made of {@Link Suit suit}  and
 * {@Link Rank rank}
 */
public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }


    @Override
    public int compareTo(Card card) {
        if (this.rank.compareTo(card.rank) > 0) {
            return 1;
        } else if (this.rank.compareTo(card.rank) < 0) {
            return -1;
        } else {
            return this.suit.compareTo(card.suit);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        return (rank == other.rank) && (suit == other.suit);
    }

    @Override
    public String toString() {
        return (suit + " " + rank);
    }

    @Override
    public int hashCode() {
        return (suit.ordinal() * 13) + rank.ordinal();
    }
}
