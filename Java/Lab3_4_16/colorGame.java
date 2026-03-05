
import java.util.Scanner;

public class colorGame {
    public static void main(String[] args) {
        int myCash = 500;
        int myvCashIn;
        int myColor, myBet;
        Scanner input = new Scanner(System.in);
        processClass pc = new processClass(myCash);
        boolean goLang = true;

        while (goLang) {
            System.out.println("Your initial cash is: " + pc.yourCash);
            System.out.println("[0] is Red");
            System.out.println("[1] is Yellow");
            System.out.println("[2] is blue");
            System.out.println("[3] is Green");
            System.out.println("[4] is Pink");
            System.out.println("[5] is While");

            System.out.print("Choose your color: ");
            myColor = input.nextInt();
            System.out.println("You Choose: " + pc.colors[myColor]);
            System.out.print("Enter your bet: ");
            myBet = input.nextInt();

            System.out.println(pc.getYourCash(myColor, myBet));

            if (pc.didYouwin)
                System.out.println("You Win");
            else
                System.out.println("You Lose!");

            if (myCash == 0) {
                System.out.println("0 balance");
                System.out.println("Recharge to play again!");
                System.out.println("Enter [0] to Recharge \n Enter [1] to exit");
                int playOrNot = input.nextInt();

                if (playOrNot == 0) {
                    System.out.println("Enter the amount: ");
                    myvCashIn = input.nextInt();
                    myCash += myvCashIn;
                }
                else
                    goLang = false;
            }
        }

    }
}