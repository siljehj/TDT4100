package oving7;

public class CardHand extends CardContainerImpl {

    // private ArrayList<Card> cardHand = new ArrayList<Card>();

    public CardHand(int n) {
       super(n);
    }

    public Card play(int n) {
        Card myCard = super.getCard(n);
        super.removeCard(myCard);
        return myCard;
        // if (isCardValid(n)) {
        //     Card myCard = getCard(n);
        //     cardHand.remove(n);
        //     return myCard;
        // } else {
        //     throw new IllegalArgumentException("Index out of range.");
        // }
    }

    public void addCard(Card card) {
        if (super.getCardCount() == super.getMaxCardCount()) {
            throw new IllegalStateException();
        }
        super.addCard(card);
    }

    public static void main(String[] args) {
        Card card1 = new Card('S',10);
        Card card2 = new Card('S',11);
        Card card3 = new Card('S',12);
        CardHand c1 = new CardHand(5);
        c1.addCard(card1);
        c1.addCard(card2);
        System.out.println(c1);
        c1.addCard(card3);
        c1.removeCard(card1);
        System.out.println(c1);
        c1.play(1);
        System.out.println(c1);

    }

}
