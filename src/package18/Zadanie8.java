package package18;
import java.util.Scanner;

public class Zadanie8 {
    public static void main(String[] args) {
        getKey();
    }

    public static void getKey() {
        Scanner myScanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter key: ");
            String key = myScanner.next();

            try {
                printDetails(key);
                validInput = true;
                System.out.println("Success! Key accepted.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
        myScanner.close();
    }

    public static void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println("Message: " + message);
        } catch (Exception e) {
            System.out.println("Error in printDetails: " + e.getMessage());
            throw new RuntimeException("Failed to process key", e);
        }
    }

    private static String getDetails(String key) {
        if (key.equals("null")) {
            throw new NullPointerException("Key cannot be null");
        }
        if (key.equals("")) {
            throw new IllegalArgumentException("Key cannot be empty");
        }
        return "data for " + key;
    }
}