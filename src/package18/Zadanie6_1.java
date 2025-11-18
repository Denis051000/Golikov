package package18;
import java.util.Scanner;
public class Zadanie6_1 {
    public static void main(String[] args) {
        printMessage();
    }

    public static void printMessage() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter key for message: ");
        String key = myScanner.next();

        String message = getDetails(key);
        System.out.println(message);
        myScanner.close();
    }

    public static String getDetails(String key) {
        if (key.equals("null")) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }
}