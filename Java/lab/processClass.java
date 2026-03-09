package lab;

public class processClass extends genClass {

    public void setResult(int playerChoice) {
        this.randomNumber1 = ran.nextInt(2);
        this.randomNumber2 = ran.nextInt(2);

        System.out.println("Player Choice: " + playerChoice);
        System.out.println("Random Number 1: " + randomNumber1);
        System.out.println("Random Number 2: " + randomNumber2);

        if (randomNumber1 != randomNumber2) {
            isDraw = true;
        } else if (playerChoice == randomNumber1) {
            isWin = true;
            winner = playerChoice;
        } else {
            System.out.println("You lose!");
        }

    }

    public int getResult(int playerChoice) {
        setResult(playerChoice);
        return winner;
    }
}
