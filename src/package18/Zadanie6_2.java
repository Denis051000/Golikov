package package18;
import java.util.Scanner;

public class Zadanie6_2 {
    public static void main(String[] args) {
        printMessage();
    }

    public static void printMessage() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter key for message: ");
        String key = myScanner.next();

        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Using default message");
            System.out.println("data for default");
        } finally {
            myScanner.close();
        }
    }

    public static String getDetails(String key) {
        if (key.equals("null")) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }
}