package oving7;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {

    private ObservableHighscoreList list;

    public ObservableHighscoreListProgram() {

    }

    public void init() {
        ObservableHighscoreList newList = new ObservableHighscoreList(4);
        this.list = newList;
        list.addObservableListListener(this);
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter integer: ");
        int num = scan.nextInt();
        list.addResult(num);
    }

    public void listChanged(ObservableList l, int index) {
        System.out.println("List: ");
        for (int i = 0; i < l.size(); i++) {
            System.out.print(list.getElement(i) + "  ");
        }
        System.out.println("\nPos: \n" + index + "\n");
    }

    public static void main(String[] args) {
        ObservableHighscoreListProgram p = new ObservableHighscoreListProgram();
        p.init();
        p.run();
        p.run();
        p.run();
        p.run();
        p.run();
        p.run();
    }
    
}
