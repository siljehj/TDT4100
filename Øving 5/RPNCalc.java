package oving5;

import java.util.ArrayList;
import java.util.Stack;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RPNCalc {

    private Stack<Double> stack = new Stack<Double>();
    private ArrayList<Character> validBinaryOperations = new ArrayList<Character>();
    private ArrayList<BinaryOperator<Double>> binaryOperators = new ArrayList<BinaryOperator<Double>>();
    private ArrayList<Character> validUnaryOperations = new ArrayList<Character>();
    private ArrayList<UnaryOperator<Double>> unaryOperators = new ArrayList<UnaryOperator<Double>>();
    private ArrayList<Character> validSuppliers = new ArrayList<Character>();
    private ArrayList<Supplier<Double>> suppliers = new ArrayList<Supplier<Double>>();

    public RPNCalc() {
    }

    public void push(double x) {
        stack.push(x);
    }

    public double pop() {
        if (getSize() == 0) {
            return Double.NaN;
        }
        return stack.pop();
    }

    public double peek(int x) {
        if (x < 0 || x >= getSize()) {
            return Double.NaN;
        } else {
            int y = getSize() - x - 1;
            return stack.get(y);
        }
    }

    public int getSize() {
        return stack.size();
    }

    public void performOperation(char c) {
        if (charAlreadyThere(c)) {
            if (whatKind(c) == binaryOperators) {
                double x = pop();
                double y = pop();
                push(binaryOperators.get(validBinaryOperations.indexOf(c)).apply(y, x));
            } else if (whatKind(c) == unaryOperators) {
                double x = pop();
                push(unaryOperators.get(validUnaryOperations.indexOf(c)).apply(x));
            } else {
                push(suppliers.get(validSuppliers.indexOf(c)).get());
            }
        } else {
            throw new UnsupportedOperationException("Operation does not exist.");

        }
    }

    public boolean addOperator(char c, BinaryOperator<Double> b) {
        if (!charAlreadyThere(c)) {
            validBinaryOperations.add(c);
            binaryOperators.add(b);
            return true;
        }
        return false;
    }

    public boolean addOperator(char c, UnaryOperator<Double> u) {
        if (!charAlreadyThere(c)) {
            validUnaryOperations.add(c);
            unaryOperators.add(u);
            return true;
        }
        return false;
    }

    public boolean addOperator(char c, Supplier<Double> s) {
        if (!charAlreadyThere(c)) {
            validSuppliers.add(c);
            suppliers.add(s);
            return true;
        }
        return false;
    }

    public void removeOperator(char c) {
        if (charAlreadyThere(c)) {
            binaryOperators.remove(validBinaryOperations.indexOf(c));
            validBinaryOperations.remove(validBinaryOperations.indexOf(c));
        } else {
            throw new IllegalArgumentException("No char to remove.");
        }
    }

    private boolean charAlreadyThere(char c) {
        if (validBinaryOperations.contains(c) || validUnaryOperations.contains(c) || validSuppliers.contains(c)) {
            return true;
        }
        return false;
    }

    private Object whatKind(char c) {
        if (validBinaryOperations.contains(c)) {
            return binaryOperators;
        } else if (validUnaryOperations.contains(c)) {
            return unaryOperators;
        } else {
            return suppliers;
        }
    }

    public String toString() {
        for (double x : stack) {
            System.out.print(x + "  ");
        }
        return "";
    }

    public static void main(String[] args) {
        RPNCalc calc = new RPNCalc();
        calc.push(1);
        calc.push(2.0);
        System.out.println(calc);
        System.out.println(calc.peek(1));
        /*
         * calc.push(5.5);
         * calc.push(2);
         * System.out.println(calc);
         * calc.performOperation('+');
         * System.out.println(calc);
         * calc.performOperation('-');
         * System.out.println(calc);
         * calc.performOperation('-');
         * System.out.println(calc);
         * calc.performOperation('|');
         * System.out.println(calc);
         */
    }


}
