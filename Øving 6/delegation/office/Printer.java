package oving6.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {

    private Map<Employee, List<String>> myMap = new HashMap<Employee, List<String>>();

    public Printer() {
    }

    public void printDocument(String document, Employee employee) {
        System.out.println(document);
        if (myMap.containsKey(employee)) {
            myMap.get(employee).add(document);
        } else {
            List<String> myList = new ArrayList<String>();
            myList.add(document);
            myMap.put(employee, myList);
        }

        // her skulle jeg liksom være smart, og det var jeg
        // men testen var ikke like smart :)
        /*if (myMap.containsKey(employee)) {
            ArrayList<String> newList = new ArrayList<String>(myMap.get(employee));
            newList.add(document);
            myMap.put(employee, Collections.unmodifiableList(newList));
        } else {
            List<String> myList = new ArrayList<String>();
            myList.add(document);
            myMap.put(employee, Collections.unmodifiableList(myList));
        }*/
    }

    public List<String> getPrintHistory(Employee employee) {
        if (myMap.containsKey(employee)) {
            ArrayList<String> newList = new ArrayList<String>(myMap.get(employee));
            return newList;
        }
        return List.of();
    }
}
