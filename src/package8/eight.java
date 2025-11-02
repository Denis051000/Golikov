package package8;

import java.util.Scanner;
public class eight {
    public static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для проверки на палиндром: ");
        String word = scanner.nextLine();
        boolean result = isPalindrome(word, 0, word.length() - 1);
        System.out.println(result ? "YES" : "NO");
        scanner.close();
    }
}
