package oving7;

import java.util.ArrayList;
import java.util.Iterator;

public class CardContainerImpl implements CardContainer {

    protected ArrayList<Card> cards = new ArrayList<Card>();
    private int maxCardCount;

    public CardContainerImpl(int x) {
        this.maxCardCount = x;
    }

    public int getCardCount() {
        return cards.size();
    }

    public Card getCard(int n) {
        if (!isCardValid(n)) {
            throw new IllegalArgumentException();
        }
        return cards.get(n);
    }

    public void addCard(Card card) {
        if (cards.contains(card)) {
            throw new IllegalArgumentException("Card already there.");
        }
        cards.add(card);
    }

    public void removeCard(Card card) {
        if (!cards.contains(card)) {
            throw new IllegalArgumentException("Card not in cards.");
        }
        cards.remove(card);
    }

    protected void removeAllCards() {
        cards.clear();
    }


    public int getMaxCardCount() {
        return maxCardCount;
    }


    private boolean isCardValid(int n) {
        return n >= 0 && n < getCardCount();
    }

    // private void validateNum(int n) {
    //     if (n < 0 || n >= cards.size()) {
    //         throw new IllegalArgumentException("Not enough cards.");
    //     }
    // }

    public String toString() {
        System.out.println("Cards: ");
        cards.stream().forEach(System.out::println);
        
        return "";
    }

    public static void main(String[] args) {
        
    }

    public Iterator<Card> iterator() {
        return new CardContainerIterator(this);
    }
    
}
