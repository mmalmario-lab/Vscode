import java.util.Scanner;

public class ExceptionHandlingDemo {

    // ===================== CUSTOM EXCEPTION CLASS =====================
    // (From your notes Page 7-8)
    // "By extending the built-in Exception class... you can create your own exception classes"
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    // ===================== MAIN DEMO =====================
    // This program demonstrates ONLY the Exception Handling concepts 
    // from the exact text you sent (no OOP mixing).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EXCEPTION HANDLING DEMO ===\n");
        System.out.println("Based ONLY on the text you sent about Java Exceptions.\n");

        // 1. TRY-CATCH BLOCK (Page 5-6)
        System.out.println("1. TRY-CATCH BLOCK (ArithmeticException):");
        try {
            // Code that may throw an exception
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Exception handling code
            System.out.println("An arithmetic exception occurred: " + e.getMessage());
        }
        System.out.println("Program continues after handling exception...\n");

        // 2. THROW KEYWORD (Page 6-7)
        System.out.println("2. THROW KEYWORD (IllegalArgumentException):");
        try {
            int age = -1;
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            System.out.println("Age: " + age);
        } catch (IllegalArgumentException e) {
            System.out.println("An illegal argument exception occurred: " + e.getMessage());
        }
        System.out.println();

        // 3. CUSTOM EXCEPTION (Page 7-8)
        System.out.println("3. CUSTOM EXCEPTION:");
        try {
            throw new CustomException("Custom exception occurred");
        } catch (CustomException e) {
            System.out.println("A custom exception occurred: " + e.getMessage());
        }
        System.out.println();

        // 4. MULTIPLE CATCH BLOCKS (Page 8-9)
        System.out.println("4. MULTIPLE CATCH BLOCKS:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);        // Throws ArrayIndexOutOfBoundsException

            String text = null;
            System.out.println(text.length());     // Throws NullPointerException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception: " + e.getMessage());
        } catch (Exception e) {   // General catch last (Page 9-10)
            System.out.println("An unexpected exception occurred: " + e.getMessage());
        }
        System.out.println();

        // 5. FINALLY BLOCK (Page 6)
        System.out.println("5. FINALLY BLOCK (cleanup always runs):");
        try {
            // Code that may throw exception
            int num = Integer.parseInt("abc");   // Throws NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } finally {
            // This always executes
            System.out.println("Finally block executed - cleanup complete.");
        }

        System.out.println("\n=== SUMMARY ===");
        System.out.println("All exception handling concepts from your text demonstrated:");
        System.out.println("• try-catch");
        System.out.println("• throw keyword");
        System.out.println("• Custom exceptions");
        System.out.println("• Multiple catch blocks");
        System.out.println("• General Exception catch");
        System.out.println("• finally block");

        scanner.close();
    }

    // Helper method that throws ArithmeticException (from your example)
    public static int divide(int dividend, int divisor) {
        return dividend / divisor;
    }
}
