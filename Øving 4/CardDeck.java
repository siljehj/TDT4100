package oving4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CardDeck {

    // state
    private ArrayList<Object> cardDeck = new ArrayList<Object>();

    public CardDeck(int n) {
        if (isNumValid(n)) {
            for (int i = 1; i <= n; i++) {
                Card myCard = new Card('S', i);
                cardDeck.add(myCard);
            }
            for (int i = 1; i <= n; i++) {
                Card myCard = new Card('H', i);
                cardDeck.add(myCard);
            }
            for (int i = 1; i <= n; i++) {
                Card myCard = new Card('D', i);
                cardDeck.add(myCard);
            }
            for (int i = 1; i <= n; i++) {
                Card myCard = new Card('C', i);
                cardDeck.add(myCard);
            }

        } else {
            throw new IllegalArgumentException("Number must be from 0 to 13.");
        }
    }

    public int getCardCount() {
        return cardDeck.size();
    }

    public Card getCard(int n) {
        if (isCardValid(n)) {
            return (Card) cardDeck.get(n);
        } else {
            throw new IllegalArgumentException("Index out of range.");
        }
    }

    public void shufflePerfectly() {
        List<Object> firstHalf = new CopyOnWriteArrayList<Object>();
        for (int i = 0; i < cardDeck.size() / 2; i++) {
            firstHalf.add(cardDeck.get(i));
        }
        List<Object> secondHalf = new CopyOnWriteArrayList<Object>();
        for (int i = cardDeck.size() / 2; i < cardDeck.size(); i++) {
            secondHalf.add(cardDeck.get(i));
        }
        cardDeck.clear();
        for (int i = 0; i < firstHalf.size(); i++) {
            cardDeck.add(firstHalf.get(i));
            cardDeck.add(secondHalf.get(i));
        }

    }

    public void deal(CardHand hand, int n) {
        if (n > 0 && n <= getCardCount()) {
            for (int i = 1; i <= n; i++) {
                Card myCard = getCard(getCardCount() - 1);
                hand.addCard(myCard);
                cardDeck.remove(getCardCount() - 1);
            }
        } else {
            throw new IllegalArgumentException("Not enough cards to deal.");
        }

    }

    private boolean isNumValid(int n) {
        if (n >= 0 && n <= 13) {
            return true;
        } else {
            return false;
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
        System.out.print("Carddeck: ");
        for (Object o : cardDeck) {
            System.out.print(o + " ");
            // System.out.print(((Card) o).getSuit() + "" + ((Card) o).getFace() + " ");
        }
        return "";
    }

    public static void main(String[] args) {
        CardDeck c = new CardDeck(6);
        CardHand d = new CardHand();
        System.out.println(c);
        c.shufflePerfectly();
        System.out.println(c);
        c.deal(d, 5);
        System.out.println(d);
        System.out.println(c);
        // System.out.println(c.getCard(9));
        
    }

}
