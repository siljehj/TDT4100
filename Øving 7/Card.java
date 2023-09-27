package oving7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card> {

    private char suit;
    private int face;

    public Card(char mySuit, int value) {
        suitIsValid(mySuit);
        numIsValid(value);
        this.suit = mySuit;
        this.face = value;
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    private void suitIsValid(char x) {
        if (x != 'S' && x != 'H' && x != 'D' && x != 'C') {
            throw new IllegalArgumentException("Invalid suit.");
        }
    }

    private void numIsValid(int x) {
        if (x < 1 || x > 13) {
            throw new IllegalArgumentException("Invalid number");
        }
    }

    public String toString() {
        return suit + "" + face;
    }

    public static void main(String[] args) {
        Card myCard = new Card('H', 13);
        Card myCard2 = new Card('S', 12);
        Card myCard3 = new Card('C', 13);
        Card myCard4 = new Card('H', 1);
        List<Card> cards = new ArrayList<Card>();
        cards.add(myCard);
        cards.add(myCard2);
        cards.add(myCard3);
        cards.add(myCard4);
        Collections.sort(cards);
        for (Card c: cards) {
            System.out.println(c);
        }

    }

    @Override
    public int compareTo(Card c) {
        if (this == c) {
            return 0;
        }
        List<Character> myList = List.of('C', 'D', 'H', 'S');
        if (myList.indexOf(this.getSuit()) < myList.indexOf(c.getSuit())) {
            return -1;
        } else if (myList.indexOf(this.getSuit()) > myList.indexOf(c.getSuit())) {
            return 1;
        } else {
            if (this.getFace() < c.getFace()) {
                return -1;
            } else {
                return 1;
            }
        }

    }

}
