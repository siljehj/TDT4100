package oving5;

import java.util.ArrayList;

public class StringGridImpl implements StringGrid {

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
    private int rowCount;
    private int columnCount;

    public StringGridImpl(int rows, int columnCount) {
        this.rowCount = rows;
        this.columnCount = columnCount;
        for (int i = 0; i < rows; i ++) {
            ArrayList<String> a = new ArrayList<String>();
            for (int j = 0; j < columnCount; j ++) {
                a.add(" ");
            }
            grid.add(a);
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public String getElement(int row, int column) {
        validatePos(row, column);
        return grid.get(row).get(column);
    }

    public void setElement(int row, int column, String element) {
        validatePos(row, column);
        grid.get(row).set(column, element);
    }

    private void validatePos(int row, int column) {
        if (0 <= row && row < rowCount && 0 <= column && column < columnCount) {
            return;
        }
        else {
            throw new IllegalArgumentException("Row or column out of range.");
        }
    }

    @Override
    public String toString() {
        for (ArrayList<String> a: grid) {
            System.out.println(a);
            /*for (String s : a) {
                System.out.print(s + " ");
            }*/
        }
        return "";
    }

    public static void main(String[] args) {
        StringGridImpl s = new StringGridImpl(5, 4);
        System.out.println(s);
        s.setElement(3, 0, "Silje");
        s.setElement(1, 2, "Jenny");
        s.setElement(4, 1, "Eines");
        System.out.println(s);
        s.setElement(5, 2, "Jenny");

    }
    
}
