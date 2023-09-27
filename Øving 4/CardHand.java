package oving4;

import java.util.ArrayList;

public class CardHand {

    private ArrayList<Object> cardHand = new ArrayList<Object>();

    public CardHand() {

    }

    public int getCardCount() {
        return cardHand.size();
    }

    public Card getCard(int n) {
        if (isCardValid(n)) {
            return (Card) cardHand.get(n);
        } else {
            throw new IllegalArgumentException("Index out of range.");
        }
    }

    public void addCard(Card card) {
        cardHand.add(card);
    }

    public Card play(int n) {
        if (isCardValid(n)) {
            Card myCard = getCard(n);
            cardHand.remove(n);
            return myCard;
        } else {
            throw new IllegalArgumentException("Index out of range.");
        }
    }

    private boolean isCardValid(int n) {
        if (n >= 0 && n < getCardCount()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        System.out.print("Cardhand: ");
        for (Object o : cardHand) {
            System.out.print(o + " ");
        }
        return "";
    }

    public static void main(String[] args) {

    }

}
