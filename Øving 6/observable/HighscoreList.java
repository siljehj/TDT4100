package oving6.observable;

import java.util.ArrayList;

public class HighscoreList {

    private int maxSize;
    private ArrayList<Integer> results = new ArrayList<Integer>();
    private ArrayList<HighscoreListListener> listeners = new ArrayList<HighscoreListListener>();

    public HighscoreList(int x) {
        if (x > 0) {
        this.maxSize = x; }
        else {
            throw new IllegalArgumentException("Lol");
        }
    }

    public int size() {
        return results.size();
    }

    public int getElement(int index) {
        validateIndex(index);
        return results.get(index);
    }

    public void addResult(int i) {
        if (resultCanBeAdded(i) > 0) {
            if (resultCanBeAdded(i) == 1) { // sjekker om lista blir for lang
                results.remove(results.size() - 1);
            }
            for (int j : results) {
                if (i < j) {
                    results.add(results.indexOf(j), i);
                    giveMessage(results.indexOf(i));
            
                    return;
                } else if (i == j) {
                    results.add(results.indexOf(j) + 1, i);
                    giveMessage(results.indexOf(j) + 1);
                    return;
                }
            }
            if (!results.contains(i)) {
                results.add(i);
                giveMessage(results.indexOf(i));
                return;
            }
        } else {
            System.out.println("Did not make the list lol");
        }
    }

    private void giveMessage(int i) {
        for (HighscoreListListener h : listeners) {
            h.listChanged(this, i);
        }
    }

    public void addHighscoreListListener(HighscoreListListener l) {
        if (!listeners.add(l)) {
            throw new IllegalArgumentException("Already listening.");
        }
    }

    public void removeHighscoreListListener(HighscoreListListener l) {
        if (!listeners.remove(l)) {
            throw new IllegalArgumentException("Not listening.");
        }
    }

    private void validateIndex(int i) {
        if (i < 0 || i >= size()) {
            throw new IllegalArgumentException("Index out of range.");
        }
    }

    private int resultCanBeAdded(int i) {
        if (size() < maxSize) {
            return 2;
        } else if (i < results.get(size() - 1)) {
            return 1;
        } else {
            return 0;
        }
    }
}
