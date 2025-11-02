package package11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Задание 4: Создание объектов Date и Calendar
 */
public class DateCreator {

    public void createDateObjects() {
        System.out.println("=== ЗАДАНИЕ 4 ===");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные для создания даты:");
            System.out.print("Год (например, 2024): ");
            int year = scanner.nextInt();

            System.out.print("Месяц (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Число: ");
            int day = scanner.nextInt();

            System.out.print("Часы (0-23): ");
            int hours = scanner.nextInt();

            System.out.print("Минуты (0-59): ");
            int minutes = scanner.nextInt();

            // Создание объекта Calendar
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1); // Месяцы с 0 до 11
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, hours);
            calendar.set(Calendar.MINUTE, minutes);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date dateFromCalendar = calendar.getTime();

            // Создание объекта Date через System.currentTimeMillis()
            long timeInMillis = calendar.getTimeInMillis();
            Date dateFromMillis = new Date(timeInMillis);

            System.out.println("\nРезультаты:");
            System.out.println("Объект Calendar: " + formatCalendar(calendar));
            System.out.println("Объект Date из Calendar: " + formatDate(dateFromCalendar));
            System.out.println("Объект Date из millis: " + formatDate(dateFromMillis));
            System.out.println("Timestamp: " + timeInMillis);

        } catch (Exception e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return formatter.format(date);
    }

    private String formatCalendar(Calendar calendar) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return formatter.format(calendar.getTime());
    }
}