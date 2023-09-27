package oving5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double>, BinaryOperator<Double> {

    private Iterator<Double> i1;
    private Iterator<Double> i2;
    private Double d1;
    private Double d2;
    private BinaryOperator<Double> operator;

    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,
            BinaryOperator<Double> operator) {
        this.i1 = iterator1;
        this.i2 = iterator2;
        this.operator = operator;
    }

    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1,
            Double default2, BinaryOperator<Double> operator) {
        this.i1 = iterator1;
        this.i2 = iterator2;
        this.d1 = default1;
        this.d2 = default2;
        this.operator = operator;
    }

    public boolean hasNext() {
        if (!i1.hasNext() && !i2.hasNext()) {
            return false;
        } else if (!i1.hasNext() && d1 == null || !i2.hasNext() && d2 == null) {
            return false;
        }
        return true;
    }

    public Double next() {
        if (this.hasNext()) {
            if (i1.hasNext() && i2.hasNext()) {
                return apply(i1.next(), i2.next());
            }
            else if (!i1.hasNext()) {
                return apply(d1, i2.next());
            }
            else {
                return apply(i1.next(), d2);
            }
        } else {
            return Double.NaN;
        }
    }

    public Double apply(Double x, Double y) {
        return operator.apply(x, y);
    }

    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        Iterator<Double> i1 = Arrays.asList(2.0, 3.0, 10.0).iterator();
        Iterator<Double> i2 = Arrays.asList(5.0).iterator();
        BinaryOperator<Double> addition = (a, b) -> a - b;
        BinaryComputingIterator bi = new BinaryComputingIterator(i1, i2, null, 10.0, addition);

        System.out.println(bi.next());
        System.out.println(bi.hasNext());
        System.out.println(bi.next());
        System.out.println(bi.hasNext());
        System.out.println(bi.next());
        System.out.println(bi.hasNext());

    }

}
