package oving4;

import java.util.ArrayList;

public class Person {

    private String name;
    private char gender;
    private Person mother;
    private Person father;
    private ArrayList<Person> children = new ArrayList<>();

    public Person(String name, char gender) {
        validateGender(gender);
        this.name = name;
        this.gender = Character.toUpperCase(gender);
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public Person getMother() {
        if (mother != null) {
            return mother;
        }
        return null;
    }

    public Person getFather() {
        if (father != null) {
            return father;
        }
        return null;
    }

    public int getChildCount() {
        return children.size();
    }

    public Person getChild(int n) {
        validateNum(n);
        return children.get(n);
    }

    public void addChild(Person person) {
        if (this.children.contains(person)) {
            return;
        }
        this.children.add(person);
        if (this.getGender() == 'F') {
            person.setMother(this);
        } else {
            person.setFather(this);
        }
    }

    public void removeChild(Person person) {
        if (!this.children.contains(person)) {
            return;
        }
        this.children.remove(person);
        if (this.getGender() == 'F') {
            if (person.getMother() == this) {
                person.mother = null;
            }
        } else {
            if (person.getFather() == this) {
                person.father = null;
            }
        }
    }

    public void setMother(Person person) {
        if (this.mother == person) {
            return;
        }
        validateMother(person);
        if (this.mother != null) {
            this.mother.removeChild(this);
        }
        this.mother = person;
        person.addChild(this);
    }

    public void setFather(Person person) {
        if (this.father == person) {
            return;
        }
        validateFather(person);
        if (this.father != null) {
            this.father.removeChild(this);
        }
        this.father = person;
        person.addChild(this);
    }

    private void validateGender(char c) {
        if (Character.toUpperCase(c) != 'F' && Character.toUpperCase(c) != 'M') {
            throw new IllegalArgumentException("Invalid gender.");
        }
    }

    private void validateNum(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("Not enough children.");
        }
    }

    private void validateMother(Person person) {
        if (person.getGender() != 'F') {
            throw new IllegalArgumentException("Female can't be father.");
        }
        if (person == this) {
            throw new IllegalArgumentException("Cannot be your own mother.");
        }
    }

    private void validateFather(Person person) {
        if (person.getGender() != 'M') {
            throw new IllegalArgumentException("Male can't be mother.");
        }
        if (person == this) {
            throw new IllegalArgumentException("Cannot be your own father.");
        }
    }

    @Override
    public String toString() {
        if (this.mother != null && this.father != null) {
            System.out.print("Name: " + name + "\nGender: " + gender + "\nMother: " + mother.getName() + "\nFather: " + father.getName()
                    + "\nChildren: ");
            for (Person p : children) {
                System.out.print(p.getName() + "\t");
            }
        } else {
            System.out.print("Name: " + name + "\nGender: " + gender + "\nChildren: ");
            for (Person p : children) {
                System.out.print(p.getName() + "\t");
            }
        }
        System.out.println("");
        return "";
    }

    public static void main(String[] args) {
        Person silje = new Person("Silje", 'F');
        Person line = new Person("Line", 'F');
        Person vegard = new Person("Vegard", 'M');
        Person bjorn = new Person("Bjørn", 'M');
        bjorn.addChild(silje);
        silje.setMother(line);
        line.addChild(vegard);
        vegard.setFather(bjorn);
        System.out.println(bjorn);
        System.out.println(line);
        System.out.println(silje);
        System.out.println(vegard);
        Person leena = new Person("Leena", 'F');
        Person gunnar = new Person("Gunnar", 'M');
        line.setMother(leena);
        gunnar.addChild(line);
        System.out.println(leena);
        System.out.println(gunnar);
        System.out.println(line);

    }

}
