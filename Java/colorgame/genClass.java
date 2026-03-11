package colorgame;

import java.util.Random;
import java.util.Scanner;

public class genClass {

    public int yourCash;
    public int myCashIn;
    public boolean didYouwin = false;
    public String[] colors = { "red", "yellow", "blue", "green", "pink", "white" };
    public int[] drawNum = new int[3];
    public Random ran = new Random();
    public Scanner input = new Scanner(System.in);

    public genClass(int myCash) {
        this.yourCash = myCash;
    }
}
