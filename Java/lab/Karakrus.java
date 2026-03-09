package lab;

import java.util.Scanner;

public class Karakrus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean drawLoop = true;

        while (drawLoop) {
            processClass process = new processClass();
            System.out.println("\n--- New Round ---");
            System.out.print("Enter your choice (0 for Kara, 1 for Krus): ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 0 && choice != 1) {
                    System.out.println("Invalid choice. Please enter 0 or 1.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (0 or 1).");
                continue;
            }

            int winner = process.getResult(choice);
            if (winner == 1 || winner == 0) {
                System.out.println("Winner: " + (winner == 0 ? "Kara" : "Krus"));
            } else {
                System.out.println("No winner this round.");
            }
            if (process.isDraw) {
                System.out.print("Press 1 to continue....... :");
                int input = Integer.parseInt(scanner.nextLine());
                if (input != 1) {
                    System.out.println("Invalid input. Please press 1 to continue.");
                    continue;
                }
            } else {
                drawLoop = false;
            }

        }
    }
}
