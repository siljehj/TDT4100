package oving4;

public class Partner {

    private String name;
    private Partner partner;

    public Partner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner newPartner) {
        if (newPartner == null) {
            Partner x = partner;
            x.partner = null;
            this.partner = null;
        } 
        else if (this.partner == null) {
            this.partner = newPartner;
            newPartner.partner = this;
        }
        else {
            // gjør de single ;))
            Partner original1 = this.partner;
            original1.partner = null;
            if (newPartner.partner != null) {
                Partner original2 = newPartner.partner;
                original2.partner = null;
            }
            // inngår nytt partnerskap
            this.partner = newPartner;
            newPartner.partner = this;
        }
    }

    @Override
    public String toString() {
        if (partner != null) {
            return "My name: " + name + ". My partner: " + partner.name;
        } else {
            return "My name: " + name;
        }
    }

    public static void main(String[] args) {
        Partner p1 = new Partner("Elise");
        Partner p2 = new Partner("Lars");
        Partner p3 = new Partner("Åmund");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        p1.setPartner(p2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        p1.setPartner(p3);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }

}
