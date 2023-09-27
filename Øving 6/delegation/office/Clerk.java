package oving6.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {

    private Printer printer;
    private int taskCount = 0;
    private int resourceCount = 1; // ???

    public Clerk(Printer printer) {
        this.printer = printer;
    }

    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount ++;
        return operation.apply(value1, value2);
    }

    public void printDocument(String document) {
        taskCount ++;
        printer.printDocument(document, this);
    }

    public int getTaskCount() {
        return taskCount;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public String toString() {
        return "Employee";
    }

    public static void main(String[] args) {
        
    }
    
}
