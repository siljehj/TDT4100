package oving6.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BinaryOperator;

public class Manager implements Employee {

    private Collection<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Employee> employeesArrayList = new ArrayList<Employee>();
    private int taskCount = 0;
    private int resourceCount = 1;

    public Manager(Collection<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("No employees.");
        }
        this.employees = employees;
        for (Employee e : employees) {
            this.resourceCount += e.getResourceCount();
        }
        ArrayList<Employee> newEmployees = new ArrayList<Employee>();
        for (Employee e : employees) {
            newEmployees.add(e);
        }
        this.employeesArrayList = newEmployees;
    }

    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount ++;
        System.out.println(employees);
        System.out.println(employeesArrayList);
        Employee luckyGuy = employeesArrayList.get(0);
        for (Employee e : employees) {
            if (e.getTaskCount() < luckyGuy.getTaskCount()) {
                luckyGuy = e;
            }
        }
        return luckyGuy.doCalculations(operation, value1, value2);
    }

    public void printDocument(String document) {
        taskCount ++;
        Employee luckyGuy = employeesArrayList.get(0);
        for (Employee e : employees) {
            if (e.getTaskCount() < luckyGuy.getTaskCount()) {
                luckyGuy = e;
            }
        }
        luckyGuy.printDocument(document);
    }

    public int getTaskCount() {
        return taskCount;
    }

    public int getResourceCount() {
        return resourceCount;

    }

}
