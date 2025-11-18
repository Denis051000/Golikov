package package18;
import java.util.Scanner;
public class Zadanie5_1 {
    public static void main(String[] args) {
        getDetails();
    }

    public static void getDetails() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter key: ");
        String key = myScanner.next();

        if (key.equals("null")) {
            throw new NullPointerException("null key in getDetails");
        }
        System.out.println("Key processed: " + key);
        myScanner.close();
    }
}