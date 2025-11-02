package package11;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Задание 1: Информация о разработчике
        DeveloperInfo developerInfo = new DeveloperInfo();
        developerInfo.printDeveloperInfo();

        // Задание 2: Сравнение дат
        DateComparator dateComparator = new DateComparator();
        dateComparator.compareDates();

        // Задание 3: Демонстрация класса Student
        demonstrateStudentClass();

        // Задание 4: Создание объектов Date и Calendar
        DateCreator dateCreator = new DateCreator();
        dateCreator.createDateObjects();

        // Задание 5: Сравнение производительности коллекций
        CollectionPerformanceTester performanceTester = new CollectionPerformanceTester();
        performanceTester.compareCollectionsPerformance();
    }

    private static void demonstrateStudentClass() {
        System.out.println("=== ЗАДАНИЕ 3 ===");

        // Создаем студентов с разными датами рождения
        Student student1 = new Student("Иван", "Петров", new Date(101, 4, 15)); // 15 мая 2001
        Student student2 = new Student("Мария", "Сидорова", new Date(99, 8, 1)); // 1 сентября 1999

        System.out.println("Студент 1:");
        System.out.println("  toString(): " + student1.toString());
        System.out.println("  Короткий формат: " + student1.getFormattedBirthDate("short"));
        System.out.println("  Средний формат: " + student1.getFormattedBirthDate("medium"));
        System.out.println("  Полный формат: " + student1.getFormattedBirthDate("full"));
        System.out.println("  ISO формат: " + student1.getFormattedBirthDate("iso"));

        System.out.println("\nСтудент 2:");
        System.out.println("  toString(): " + student2.toString());
        System.out.println("  Короткий формат: " + student2.getFormattedBirthDate("short"));
        System.out.println("  Средний формат: " + student2.getFormattedBirthDate("medium"));
        System.out.println("  Полный формат: " + student2.getFormattedBirthDate("full"));
        System.out.println();
    }
}