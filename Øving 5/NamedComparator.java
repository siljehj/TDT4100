package oving5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {
    
    public NamedComparator() {

    }

    public int compare(Named p1, Named p2) {
        if (p1.getFamilyName().compareTo(p2.getFamilyName()) == 0) {
            return p1.getGivenName().compareTo(p2.getGivenName());
        }
        return p1.getFamilyName().compareTo(p2.getFamilyName());
    }

    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Named> myList = new ArrayList<Named>();
        Person1 p1 = new Person1("Silje", "Johannesen");
        Person2 p2 = new Person2("Vegard Johannesen");
        Person1 p3 = new Person1("Line", "Holm");
        Person2 p4 = new Person2("Bjørn Johannesen");
        Collections.addAll(myList, p1, p2, p3, p4);
        for (Named p: myList) {
            System.out.println(p.getFullName());
        }
        myList.sort(new NamedComparator());
        for (Named p: myList) {
            System.out.println(p.getFullName());
        }
    }
    

}
