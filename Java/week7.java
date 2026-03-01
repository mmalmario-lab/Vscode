import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FULL OOP DEMO: Advanced Authentication System
 * 
 * This program demonstrates ALL the OOP concepts you studied:
 *   • Encapsulation
 *   • Inheritance
 *   • Abstract Class
 *   • Interface
 *   • Polymorphism
 * 
 * Every code block now has clear notes explaining exactly what it does.
 */

//////////////////////////////////////////////////////
// 1. INTERFACE - Defines the contract (blueprint)
//////////////////////////////////////////////////////
// This interface says: "Any class that wants to be 'Authenticatable'
// MUST implement these 3 methods. It creates a promise/contract.
interface Authenticatable {
    
    // Method that will handle login logic
    boolean login(String username, String password);
    
    // Returns the role of the user (used for polymorphism)
    String getRole();
    
    // Method to log the user out
    void logout();
}

//////////////////////////////////////////////////////
// 2. ABSTRACT CLASS - Template for all users
// (Cannot be created directly, provides common code)
//////////////////////////////////////////////////////
// This abstract class implements the Authenticatable interface
// and provides shared functionality for ALL user types.
// It uses ENCAPSULATION to protect username/password.
abstract class AbstractUser implements Authenticatable {
    
    // ENCAPSULATION: These fields are private so no other class
    // can directly change them. Only methods inside this class can access them.
    private String username;
    private String password;
    private boolean isLoggedIn = false;

    // Constructor - runs when a new user is created
    // It calls the setter to ensure password validation happens
    protected AbstractUser(String username, String password) {
        this.username = username;
        setPassword(password);   // safe way to store password
    }

    // GETTER (Accessor) - Allows safe reading of username
    public String getUsername() {
        return username;
    }

    // SETTER (Mutator) with validation - Protects the password
    // Only allows passwords that are at least 6 characters
    public void setPassword(String newPassword) {
        if (newPassword == null || newPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters!");
        }
        this.password = newPassword;
    }

    // Common login logic shared by RegularUser and AdminUser
    // This is the default implementation from the interface
    @Override
    public boolean login(String enteredUser, String enteredPass) {
        if (this.username.equals(enteredUser) && this.password.equals(enteredPass)) {
            this.isLoggedIn = true;
            System.out.println("✅ Login successful!");
            return true;
        }
        System.out.println("❌ Invalid credentials.");
        return false;
    }

    // Logout method - resets the login status
    @Override
    public void logout() {
        this.isLoggedIn = false;
        System.out.println("👋 Logged out.");
    }

    // ABSTRACT METHOD - Subclasses MUST implement this
    // This is where polymorphism happens (different welcome messages)
    public abstract void welcomeMessage();
}

//////////////////////////////////////////////////////
// 3. CONCRETE CLASS 1 - Regular User
// Inherits everything from AbstractUser + adds its own behavior
//////////////////////////////////////////////////////
// Inheritance in action: RegularUser extends AbstractUser
// It only needs to provide the abstract method and its role
class RegularUser extends AbstractUser {

    // Constructor calls the parent constructor (super)
    public RegularUser(String username, String password) {
        super(username, password);
    }

    // Returns role - used in polymorphism
    @Override
    public String getRole() {
        return "Regular User";
    }

    // Method Overriding - This version runs when a RegularUser logs in
    @Override
    public void welcomeMessage() {
        System.out.println("Welcome back, " + getUsername() + "! 👋");
    }
}

//////////////////////////////////////////////////////
// 3. CONCRETE CLASS 2 - Admin User
// Also inherits from AbstractUser but has extra powers
//////////////////////////////////////////////////////
// Inheritance + extra features
class AdminUser extends AbstractUser {

    public AdminUser(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "Administrator";
    }

    // Different welcome message (Method Overriding)
    @Override
    public void welcomeMessage() {
        System.out.println("🔐 Welcome, Administrator " + getUsername() + "!");
        System.out.println("   You have full system access.");
    }

    // Extra method ONLY available to AdminUser
    public void deleteUser(String username) {
        System.out.println("🗑️  Admin deleted user: " + username);
    }
}

//////////////////////////////////////////////////////
// 4. MAIN CLASS - The program that runs everything
// Demonstrates polymorphism with a List of Authenticatable objects
//////////////////////////////////////////////////////
public class OOPConceptsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Polymorphic list: Can hold ANY class that implements Authenticatable
        // (RegularUser and AdminUser both qualify)
        List<Authenticatable> users = new ArrayList<>();

        System.out.println("=== Advanced OOP Authentication System ===\n");

        // ===================== REGISTRATION BLOCK =====================
        // Creates two different types of users using Inheritance
        System.out.print("Create Regular User - Username: ");
        String regUser = scanner.nextLine();
        System.out.print("Password: ");
        String regPass = scanner.nextLine();
        RegularUser regular = new RegularUser(regUser, regPass);
        users.add(regular);   // added to polymorphic list

        System.out.print("\nCreate Admin User - Username: ");
        String adminUser = scanner.nextLine();
        System.out.print("Password: ");
        String adminPass = scanner.nextLine();
        AdminUser admin = new AdminUser(adminUser, adminPass);
        users.add(admin);

        System.out.println("\n✅ Accounts created successfully!\n");

        // ===================== LOGIN & DEMO BLOCK =====================
        // This loop shows Polymorphism in action
        boolean running = true;
        while (running) {
            System.out.print("Enter username to login (or type 'exit'): ");
            String loginUser = scanner.nextLine();
            if (loginUser.equalsIgnoreCase("exit")) break;

            System.out.print("Enter password: ");
            String loginPass = scanner.nextLine();

            // Loop through all users (Regular + Admin)
            // The same code works for both because of polymorphism!
            for (Authenticatable user : users) {
                if (user.login(loginUser, loginPass)) {   // calls correct login()
                    
                    user.welcomeMessage();   // calls the overridden version (different for each user type)

                    // Type checking to access admin-only method
                    if (user instanceof AdminUser) {
                        System.out.print("Do you want to delete a user? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("Username to delete: ");
                            ((AdminUser) user).deleteUser(scanner.nextLine());
                        }
                    }

                    user.logout();   // common method from abstract class
                    break;
                }
            }
        }

        System.out.println("\nThank you for exploring OOP concepts! 🎉");
        scanner.close();
    }
}
