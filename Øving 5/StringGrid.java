package oving5;

public interface StringGrid {
    
    // Returns the number of rows in this StringGrid
    public int getRowCount();
    // Returns the number of columns in this StringGrid
    public int getColumnCount();

    // Returns the String at the given row and column. Throws an IllegalArgumentException if the row or column is out of range
    public String getElement(int row, int column);
    // Sets the String at the given row and column. Throws an IllegalArgumentException if the row or column is out of range
    public void setElement(int row, int column, String element);

}
