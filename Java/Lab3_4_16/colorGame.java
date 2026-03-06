
import java.util.Scanner;

public class colorGame {
    public static void main(String[] args) {
        int myCash = 500;
        int myColor, myBet;
        processClass pc = new processClass(myCash);
        Scanner input = new Scanner(System.in);
        boolean goLang = true;

        while (goLang) {
            if (pc.yourCash != 0) {
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

                if (myColor < pc.colors.length || myBet > myCash) {
                    System.out.println(" Invalid Input");
                    continue;
                }
                System.out.println(pc.getYourCash(myColor, myBet));

                if (pc.didYouwin)
                    System.out.println("You Win");
                else
                    System.out.println("You Lose!");
            } else {
                System.out.println("0 balance");
                System.out.println("Recharge to play again!");
                System.out.print("Enter [0] to Recharge \nEnter [1] to exit");
                int playOrNot = input.nextInt();

                if (playOrNot == 0) {
                    System.out.println("Enter the amount: ");
                    pc.myCashIn = input.nextInt();
                    pc.yourCash += pc.myCashIn;
                }
                else if (playOrNot == 1) {
                    goLang = false;
                }
                else {
                    System.out.println("Invalid Input: ");
                }
            }

        }

    }
}