package oving7;

public class ObservableHighscoreList extends ObservableList {

    private int maxSize;

    public ObservableHighscoreList(int x) {
        if (x > 0) {
            this.maxSize = x;
        }
    }

    public void addResult(int newResult) {
        if (findIndex(newResult) >= 0) {
            super.addElement(findIndex(newResult), newResult);
        } else {
            System.out.println("Did not make the list.");
        }
    }

    @Override
    protected boolean acceptsElement(Object o) {
        return o instanceof Integer;
    }

    private int findIndex(int newResult) {
        if (super.size() == 0) {
            return 0;
        }
        if (super.size() == maxSize) {
            int lastElement = (Integer) super.getElement(super.size() - 1);
            if (newResult >= lastElement) {
                return -1;
            } else {
                super.removeElement(super.size() - 1);
            }
        }
        for (int index = 0; index < super.size(); index++) {
            int elem = (Integer) super.getElement(index);
            if (newResult < elem) {
                return index;
            }
        }
        return super.size();
    }

}
