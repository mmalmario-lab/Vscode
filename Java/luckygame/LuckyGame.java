package luckygame;

import java.util.Scanner;

public class LuckyGame {
    public static void main(String[] args) {

        int goPlay, c, p;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Press 1 to play: ");
        goPlay = scanner.nextInt();

        playClass play = new playClass();
        p = play.getPlayerNum();
        c = play.getComNum();

        if (p > c) {
            System.out.println("Congratulations! You win!");
        } else if (p < c) {
            System.out.println("Computer wins! Better luck next time.");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
