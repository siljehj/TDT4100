package oving7;

import java.util.ArrayList;

public class CardDeck extends CardContainerImpl {

    public CardDeck(int n) {
        super(52);
        numIsValid(n);
        for (int i = 1; i <= n; i++) {
            Card myCard = new Card('S', i);
            addCard(myCard);
        }
        for (int i = 1; i <= n; i++) {
            Card myCard = new Card('H', i);
            addCard(myCard);
        }
        for (int i = 1; i <= n; i++) {
            Card myCard = new Card('D', i);
            addCard(myCard);
        }
        for (int i = 1; i <= n; i++) {
            Card myCard = new Card('C', i);
            addCard(myCard);
        }
    }
    
    // public CardDeck(int n) {
    //     if (isNumValid(n)) {
    //         for (int i = 1; i <= n; i++) {
    //             Card myCard = new Card('S', i);
    //             cardDeck.add(myCard);
    //         }
    //         for (int i = 1; i <= n; i++) {
    //             Card myCard = new Card('H', i);
    //             cardDeck.add(myCard);
    //         }
    //         for (int i = 1; i <= n; i++) {
    //             Card myCard = new Card('D', i);
    //             cardDeck.add(myCard);
    //         }
    //         for (int i = 1; i <= n; i++) {
    //             Card myCard = new Card('C', i);
    //             cardDeck.add(myCard);
    //         }

    //     } else {
    //         throw new IllegalArgumentException("Number must be from 0 to 13.");
    //     }
    // }

    public void shufflePerfectly() {
        ArrayList<Card> firstHalf = new ArrayList<Card>();
        for (int i = 0; i < super.getCardCount() / 2; i++) {
            firstHalf.add(super.getCard(i));
        }
        ArrayList<Card> secondHalf = new ArrayList<Card>();
        for (int i = super.getCardCount() / 2; i < super.getCardCount(); i++) {
            secondHalf.add(super.getCard(i));
        }
        super.removeAllCards();
        for (int i = 0; i < firstHalf.size(); i++) {
            super.addCard(firstHalf.get(i));
            super.addCard(secondHalf.get(i));
        }

    }

    public void deal(CardHand hand, int n) {
        if (n > 0 && n <= super.getCardCount()) {
            for (int i = 1; i <= n; i++) {
                Card myCard = getCard(getCardCount() - 1);
                hand.addCard(myCard);
                super.removeCard(super.getCard(getCardCount() - 1));
            }
        } else {
            throw new IllegalArgumentException("Not enough cards to deal.");
        }

    }

    private void numIsValid(int n) {
        if (n < 0 || n > 13) {
            throw new IllegalArgumentException("Number must be from 0 to 13.");
        } 
    }

    // public String toString() {
    //     System.out.print("Carddeck: ");
    //     for (Object o : cardDeck) {
    //         System.out.print(o + " ");
    //         // System.out.print(((Card) o).getSuit() + "" + ((Card) o).getFace() + " ");
    //     }
    //     return "";
    // }

    public static void main(String[] args) {
        CardDeck c = new CardDeck(6);
        CardHand d = new CardHand(4);
        System.out.println(c);
        c.shufflePerfectly();
        System.out.println(c);
        c.deal(d, 5);
        System.out.println(d);
        System.out.println(c);
        // System.out.println(c.getCard(9));
        
    }

}
