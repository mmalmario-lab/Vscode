import java.util.Scanner;

// 1. We create a separate class to handle password logic
class Authenticator {
    // We keep the correct password private so other classes can't accidentally
    // change it
    private String password, comfirmPassword, userName;

    // The constructor sets up the correct password when we create the object
    public Authenticator(String passwordToSet, String confirmPassword, String userName) {
        this.password = passwordToSet;
        this.comfirmPassword = confirmPassword;
        this.userName = userName;
    }

    // This method confirms if the entered password is right
    public boolean verifyPassword(String enteredPassword, String confirmPassword, String userName) {
        if (this.password.equals(enteredPassword) && this.comfirmPassword.equals(confirmPassword)
                && this.userName.equals(userName)) {
            System.out.println("Password is correct.");
            System.out.println("Welcome, user!");
        } else {
            System.out.println("Password is incorrect.");
        }
        return this.password.equals(enteredPassword) && this.comfirmPassword.equals(confirmPassword);
    }
}

// 2. This is our main program that interacts with the user
public class PasswordCheckerOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an Authenticator object and give it the secret password

        System.out.print("Enter an user name: ");
        String userInput = scanner.nextLine();

        System.out.print("Enter a password: ");
        String passwordInput = scanner.nextLine();
        System.out.print("Confirm your password: ");
        String confirmPasswordInput = scanner.nextLine();

        Authenticator auth = new Authenticator(passwordInput, confirmPasswordInput, userInput);
        ;

    }
}