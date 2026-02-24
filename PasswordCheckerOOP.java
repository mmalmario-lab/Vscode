import java.util.Scanner;

// 1. We create a separate class to handle password logic
class Authenticator {
    // We keep the correct password private so other classes can't accidentally
    // change it
    private String correctPassword;

    // The constructor sets up the correct password when we create the object
    public Authenticator(String passwordToSet) {
        this.correctPassword = passwordToSet;
    }

    // This method confirms if the entered password is right
    public boolean verifyPassword(String enteredPassword) {
        return this.correctPassword.equals(enteredPassword);
    }
}

// 2. This is our main program that interacts with the user
public class PasswordCheckerOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an Authenticator object and give it the secret password
        Authenticator auth = new Authenticator("Secret123");

        System.out.print("Please enter the password: ");
        String userInput = scanner.nextLine();

        // Ask the Authenticator class if the password is correct
        if (auth.verifyPassword(userInput)) {
            System.out.println("Access Granted. Welcome!");
        } else {
            System.out.println("Access Denied. Incorrect password.");
        }

        scanner.close();
    }
}