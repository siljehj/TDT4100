package oving5;

public class Person1 implements Named {

    private String givenName;
    private String familyName;

    public Person1(String firstName, String familyName) {
        this.givenName = firstName;
        this.familyName = familyName;
    }
    
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFullName(String fullName) {
        this.setGivenName(fullName.substring(0, fullName.indexOf(" ")));
        this.setFamilyName(fullName.substring(fullName.indexOf(" ") + 1));
    }

    public String getFullName() {
        return givenName + " " + familyName;
    }

    public String toString() {
        return givenName + " " + familyName;
    }

    public static void main(String[] args) {
        Person1 p1 = new Person1("Silje", "Johannesen");
        Person2 p2 = new Person2("Silje Johannesen");
        System.out.println(p1);
        System.out.println(p2);
    }
}
