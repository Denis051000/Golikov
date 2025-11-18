package package18;
import java.util.Scanner;
public class Zadanie4 {
    public static void main(String[] args) {
        exceptionDemo();
    }
    public static void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: please enter a valid integer");
        } catch (ArithmeticException e) {
            System.out.println("Error: division by zero is not allowed");
        } finally {
            myScanner.close();
        }
    }
}
//При запуске программы блок finally выполняется всегда. Это гарантирует, что ресурсы (Scanner) будут корректно освобождены.