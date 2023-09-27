package oving7;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{

    private CardContainer container;
    private int index;


    public CardContainerIterator(CardContainer container) {
        this.container = container;
    }

    public boolean hasNext() {
        return index < container.getCardCount();
    }

    public Card next() {
        if (hasNext()) {
            index ++;
            return container.getCard(index - 1);
        }
        return null; 
    }

}
