package oving5;

public class Person2 implements Named {

    private String fullName;

    public Person2(String fullName) {
        this.fullName = fullName;
    }

    public void setGivenName(String givenName) {
        this.fullName = givenName + fullName.substring(fullName.indexOf(" "));
    }

    public String getGivenName() {
        return this.fullName.substring(0, fullName.indexOf(" "));
    }

    public void setFamilyName(String familyName) {
        this.fullName = fullName.substring(0, fullName.indexOf(" ")) + " " + familyName;
    }

    public String getFamilyName() {
        return this.fullName.substring(fullName.indexOf(" ") + 1);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String toString() {
        return fullName;
    }
    public static void main(String[] args) {
        
    }

}
