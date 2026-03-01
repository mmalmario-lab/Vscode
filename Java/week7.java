import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FULL OOP DEMO: Advanced Authentication System
 * This single program demonstrates EVERY concept you just studied:
 *   • Encapsulation (private fields + getters/setters with validation)
 *   • Inheritance (RegularUser & AdminUser extend AbstractUser)
 *   • Abstract Class (AbstractUser)
 *   • Interface (Authenticatable)
 *   • Polymorphism (same method behaves differently for different user types)
 *
 * Build on your original PasswordCheckerOOP – now it's production-ready!
 */

//////////////////////////////////////////////////////
// 1. INTERFACE (defines the contract)
//////////////////////////////////////////////////////
interface Authenticatable {
    boolean login(String username, String password);   // must be implemented
    String getRole();                                  // for polymorphism
    void logout();
}

//////////////////////////////////////////////////////
// 2. ABSTRACT CLASS (template with common code)
//////////////////////////////////////////////////////
abstract class AbstractUser implements Authenticatable {
    // ENCAPSULATION: data is private, only accessible via methods
    private String username;
    private String password;   // hashed in real apps, but plain for demo
    private boolean isLoggedIn = false;

    // Constructor (called by subclasses)
    protected AbstractUser(String username, String password) {
        this.username = username;
        setPassword(password);   // use setter for validation
    }

    // GETTER (accessor) - read-only access
    public String getUsername() {
        return username;
    }

    // SETTER (mutator) with validation - protects internal state
    public void setPassword(String newPassword) {
        if (newPassword == null || newPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters!");
        }
        this.password = newPassword;
    }

    // Common login logic shared by all users
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

    @Override
    public void logout() {
        this.isLoggedIn = false;
        System.out.println("👋 Logged out.");
    }

    // Abstract method - subclasses MUST implement their own version (polymorphism!)
    public abstract void welcomeMessage();
}

//////////////////////////////////////////////////////
// 3. CONCRETE CLASSES (Inheritance + Polymorphism)
//////////////////////////////////////////////////////

// Regular user inherits everything from AbstractUser
class RegularUser extends AbstractUser {
    public RegularUser(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "Regular User";
    }

    // Method Overriding - different behavior
    @Override
    public void welcomeMessage() {
        System.out.println("Welcome back, " + getUsername() + "! 👋");
    }
}

// Admin user inherits AND adds extra capabilities
class AdminUser extends AbstractUser {
    public AdminUser(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "Administrator";
    }

    // Method Overriding + extra admin feature
    @Override
    public void welcomeMessage() {
        System.out.println("🔐 Welcome, Administrator " + getUsername() + "!");
        System.out.println("   You have full system access.");
    }

    // New method only available to admins
    public void deleteUser(String username) {
        System.out.println("🗑️  Admin deleted user: " + username);
    }
}

//////////////////////////////////////////////////////
// 4. MAIN PROGRAM (Polymorphism in action)
//////////////////////////////////////////////////////
public class OOPConceptsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Authenticatable> users = new ArrayList<>();   // Polymorphic list!

        System.out.println("=== Advanced OOP Authentication System ===\n");

        // Registration phase (Encapsulation + Inheritance)
        System.out.print("Create Regular User - Username: ");
        String regUser = scanner.nextLine();
        System.out.print("Password: ");
        String regPass = scanner.nextLine();
        RegularUser regular = new RegularUser(regUser, regPass);
        users.add(regular);

        System.out.print("\nCreate Admin User - Username: ");
        String adminUser = scanner.nextLine();
        System.out.print("Password: ");
        String adminPass = scanner.nextLine();
        AdminUser admin = new AdminUser(adminUser, adminPass);
        users.add(admin);

        System.out.println("\n✅ Accounts created successfully!\n");

        // Login phase - demonstrating Polymorphism
        boolean running = true;
        while (running) {
            System.out.print("Enter username to login (or type 'exit'): ");
            String loginUser = scanner.nextLine();
            if (loginUser.equalsIgnoreCase("exit")) break;

            System.out.print("Enter password: ");
            String loginPass = scanner.nextLine();

            // Polymorphism: same loop works for ANY Authenticatable object!
            for (Authenticatable user : users) {
                if (user.login(loginUser, loginPass)) {
                    user.welcomeMessage();   // calls the correct overridden version

                    // Extra admin feature (type checking)
                    if (user instanceof AdminUser) {
                        System.out.print("Do you want to delete a user? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("Username to delete: ");
                            ((AdminUser) user).deleteUser(scanner.nextLine());
                        }
                    }

                    user.logout();
                    break;
                }
            }
        }

        System.out.println("\nThank you for exploring OOP concepts! 🎉");
        scanner.close();
    }
}
/*
Concept,Where you see it,Why it matters
Encapsulation,"private fields + getUsername(), setPassword() with validation",Protects data from accidental changes
Inheritance,RegularUser and AdminUser extend AbstractUser,Reuses common code
Abstract Class,AbstractUser (has abstract welcomeMessage()),Forces subclasses to provide their own version
Interface,Authenticatable (implemented by AbstractUser),Defines a contract that any login system must follow
Polymorphism,List<Authenticatable> and calling login() / welcomeMessage(),Same code works for RegularUser OR AdminUser
*/
