package oving4;

public class Card {

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
        System.out.println(myCard);

    }

}
