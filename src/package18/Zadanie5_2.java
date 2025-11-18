package package18;
import java.util.Scanner;

public class Zadanie5_2 {
    public static void main(String[] args) {
        getDetails();
    }

    public static void getDetails() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter key: ");
        String key = myScanner.next();

        try {
            if (key.equals("null")) {
                throw new NullPointerException("null key in getDetails");
            }
            System.out.println("Key processed: " + key);
        } catch (NullPointerException e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Using default key");
            System.out.println("Key processed: default");
        } finally {
            myScanner.close();
        }
    }
}
//Это правильный подход, потому что метод getDetails() сам знает, как исправить ситуацию с null-ключом, вместо того чтобы перекладывать ответственность на вызывающий код.