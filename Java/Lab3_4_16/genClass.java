import java.util.Random;

public class genClass {

    public int yourCash;
    public boolean didYouwin = false;
    public String[] colors = { "red", "yellow", "blue", "green", "pink", "white" };
    public int[] drawNum = new int[3];
    public Random ran = new Random();

    public genClass(int myCash) {
        this.yourCash = myCash;
    }

}
