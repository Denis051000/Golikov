package package11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Задание 2: Сравнение дат
 */
public class DateComparator {

    public void compareDates() {
        System.out.println("=== ЗАДАНИЕ 2 ===");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите дату в формате ДД.ММ.ГГГГ: ");
            String inputDate = scanner.nextLine();

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            formatter.setLenient(false);

            Date userDate = formatter.parse(inputDate);
            Date currentDate = new Date();

            System.out.println("Введенная дата: " + formatter.format(userDate));
            System.out.println("Текущая дата: " + formatter.format(currentDate));

            int comparison = userDate.compareTo(currentDate);

            if (comparison < 0) {
                System.out.println("Введенная дата РАНЬШЕ текущей даты");
            } else if (comparison > 0) {
                System.out.println("Введенная дата ПОЗЖЕ текущей даты");
            } else {
                System.out.println("Даты РАВНЫ");
            }

        } catch (ParseException e) {
            System.out.println("Ошибка: Неверный формат даты! Используйте ДД.ММ.ГГГГ");
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        }
        System.out.println();
    }
}