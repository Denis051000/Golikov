package package19;
import java.util.Scanner;
public class ONLINESTORE {
    public static void main(String[] args) {
        ORDERSERVICE orderService = new ORDERSERVICE();
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String third = scanner.nextLine();
        String INN = scanner.nextLine();
        System.out.println("Клиент");
        CLIENT validClient = new CLIENT(first, second, third, INN);
        orderService.placeOrder(validClient);

    }
}