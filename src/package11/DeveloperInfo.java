package package11;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Задание 1: Информация о разработчике и времени выполнения задания
 */
public class DeveloperInfo {

    public void printDeveloperInfo() {
        System.out.println("=== ЗАДАНИЕ 1 ===");
        System.out.println("Разработчик: Петров Алексей Сергеевич");

        // Дата и время получения задания (фиксированная дата)
        Date receivedDate = new Date(124, 0, 15, 10, 0, 0); // 15 января 2024, 10:00
        System.out.println("Дата и время получения задания: " +
                formatDate(receivedDate, "dd.MM.yyyy HH:mm:ss"));

        // Текущая дата и время (сдача задания)
        Date currentDate = new Date();
        System.out.println("Дата и время сдачи задания: " +
                formatDate(currentDate, "dd.MM.yyyy HH:mm:ss"));
        System.out.println();
    }

    private String formatDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
}