package oving6.observable;

// import java.util.Random;
import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener {

    private HighscoreList list;

    public HighscoreListProgram() {

    }

    public void init() {
        // Random x = new Random();
        // int y = x.nextInt();
        HighscoreList list = new HighscoreList(3);
        this.list = list;
        list.addHighscoreListListener(this);
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter integer: ");
        int num = scan.nextInt();
        list.addResult(num);
    }

    public void listChanged(HighscoreList list, int x) {
        System.out.println("List: ");
        for (int y = 0; y < list.size(); y++) {
            System.out.print(list.getElement(y) + "  ");
        }
        System.out.println("\nPos: \n" + x + "\n");
    }

    public static void main(String[] args) {
        HighscoreListProgram p = new HighscoreListProgram();
        p.init();
        p.run();
        p.run();
        p.run();
        p.run();
        p.run();

    }

}
