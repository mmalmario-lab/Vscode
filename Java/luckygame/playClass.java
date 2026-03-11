package luckygame;

import java.util.Random;

public class playClass {

    public int playerNum, comNum;
    public Random ran = new Random();

    private void setPlayerNum() {
        int pcards = ran.nextInt(10); // Generates a random number between 0 and 9
        int pcards1 = ran.nextInt(10); // Generates a random number between 0 and 9

        int reminder = (pcards + pcards1) % 10; // Calculate the sum and take the remainder when divided by 10
        playerNum = reminder; // Set playerNum to the calculated remainder
        System.out.println("Player's number: " + pcards + ", " + pcards1);
    }

    public int getPlayerNum() {
        setPlayerNum(); // Call the method to set playerNum and comNum
        return playerNum;
    }

    private void setComNum() {
        int comcards = ran.nextInt(10); // Generates a random number between 0 and 9
        int comcards1 = ran.nextInt(10); // Generates a random number between 0 and 9
        int reminder = (comcards + comcards1) % 10; // Calculate the sum and take the remainder when divided by 10
        comNum = reminder; // Set comNum to the calculated remainder
        System.out.println("Computer's number: " + comcards + ", " + comcards1); // Print the computer's number
    }

    public int getComNum() {
        setComNum(); // Call the method to set comNum
        return comNum;
    }

}
