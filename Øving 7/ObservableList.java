package oving7;

import java.util.ArrayList;

public abstract class ObservableList {

    ArrayList<Object> list = new ArrayList<>();
    ArrayList<ObservableListListener> listeners = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public Object getElement(int index) {
        validateIndex(index);
        return list.get(index);
    }

    protected abstract boolean acceptsElement(Object o);

    protected void addElement(int index, Object o) {
        validateElement(o);
        validateAddIndex(index);
        list.add(index, o);
        listeners.stream().forEach(l -> l.listChanged(this, index));
    }

    protected void addElement(Object o) {
        validateElement(o);
        list.add(o);
        listeners.stream().forEach(l -> l.listChanged(this, size() - 1));
    }

    protected void removeElement(int index) {
        validateIndex(index);
        list.remove(index);
    }

    public void addObservableListListener(ObservableListListener listener) {
        if (!listenerInList(listener)) {
            listeners.add(listener);
        }
    }

    public void removeObservableListListener(ObservableListListener listener) {
        if (listenerInList(listener)) {
            listeners.remove(listener);
        }
    }

    private void validateAddIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
    }
    private void validateIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
    }

    private void validateElement(Object o) {
        if (!acceptsElement(o)) {
            throw new IllegalArgumentException("Element not accepted.");
        }
    }

    private boolean listenerInList(ObservableListListener listener) {
        return listeners.contains(listener);
    }

}
