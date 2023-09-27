package oving5;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {

    private StringGrid grid;
    private boolean rowMajor;
    private int rowPos = 0;
    private int columnPos = 0;

    public StringGridIterator(StringGrid grid, boolean bool) {
        this.grid = grid;
        this.rowMajor = bool;
    }

    public boolean hasNext() {
        return rowPos < grid.getRowCount() && columnPos < grid.getColumnCount();
    }

    public String next() {
        if (hasNext()) {
            String s = grid.getElement(rowPos, columnPos);
            if (rowMajor) {
                if (columnPos == grid.getColumnCount() - 1) {
                    rowPos++;
                    columnPos = 0;
                } else {
                    columnPos++;
                }
            } else {
                if (rowPos == grid.getRowCount() - 1) {
                    columnPos++;
                    rowPos = 0;
                } else {
                    rowPos++;
                }
            }
            return s;
        }
        return null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove strings from grid.");
    }

}
