package package8;

import java.util.Scanner;

public class seven {
    public static void seven(int n, int del) {
        if (n <= 1) return;

        if (n % del == 0) {
            System.out.print(del+ " ");
            seven(n / del, del);
        } else {
            seven(n, del + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число (n > 1): ");
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("Число должно быть больше 1!");
        } else {
            System.out.print("Простые множители " + n + ": ");
            seven(n, 2);
            System.out.println();
        }

        scanner.close();
    }
}
