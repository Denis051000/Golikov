package package18;
import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args) {
        getKey();
    }

    public static void getKey() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter key: ");
        String key = myScanner.next();
        try {
            printDetails(key);
        } catch (Exception e) {
            System.out.println("Обработано в getKey(): " + e.getMessage());
        } finally {
            myScanner.close();
        }
    }

    public static void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Обработано в printDetails(): " + e.getMessage());
        }
    }

    private static String getDetails(String key) {
        if (key.equals("")) {
            throw new RuntimeException("Key set to empty string"); // Используем unchecked исключение
        }
        return "data for " + key;
    }
}