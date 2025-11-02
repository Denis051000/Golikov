package package11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Задание 5: Сравнение производительности ArrayList и LinkedList
 */
public class CollectionPerformanceTester {
    private static final int ELEMENT_COUNT = 100000;
    private static final int TEST_ITERATIONS = 1000;

    public void compareCollectionsPerformance() {
        System.out.println("=== ЗАДАНИЕ 5 ===");
        System.out.printf("Тестирование на %d элементах%n%n", ELEMENT_COUNT);

        // Тестирование ArrayList
        List<Integer> arrayList = new ArrayList<>();
        testListPerformance(arrayList, "ArrayList");

        // Тестирование LinkedList
        List<Integer> linkedList = new LinkedList<>();
        testListPerformance(linkedList, "LinkedList");

        printComparisonResults();
    }

    private void testListPerformance(List<Integer> list, String listName) {
        System.out.println("Тестирование " + listName + ":");

        // Тест добавления в конец
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            list.add(i);
        }
        long addTime = System.nanoTime() - startTime;

        // Тест вставки в начало
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            list.add(0, i);
        }
        long insertBeginningTime = System.nanoTime() - startTime;

        // Тест вставки в середину
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            list.add(list.size() / 2, i);
        }
        long insertMiddleTime = System.nanoTime() - startTime;

        // Тест доступа по индексу
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            list.get(i * 10);
        }
        long accessTime = System.nanoTime() - startTime;

        // Тест поиска элемента
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            list.contains(i * 100);
        }
        long searchTime = System.nanoTime() - startTime;

        // Тест удаления из начала
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            if (!list.isEmpty()) {
                list.remove(0);
            }
        }
        long removeBeginningTime = System.nanoTime() - startTime;

        // Тест удаления из середины
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            if (list.size() > 1) {
                list.remove(list.size() / 2);
            }
        }
        long removeMiddleTime = System.nanoTime() - startTime;

        // Сохранение результатов
        PerformanceResults results = new PerformanceResults(
                addTime, insertBeginningTime, insertMiddleTime,
                accessTime, searchTime, removeBeginningTime, removeMiddleTime
        );

        results.printResults(listName);
    }

    private void printComparisonResults() {
        System.out.println("\n=== АНАЛИЗ РЕЗУЛЬТАТОВ ===");
        System.out.println("ArrayList лучше для:");
        System.out.println("  - Доступа по индексу (get)");
        System.out.println("  - Поиска элементов в небольших коллекциях");
        System.out.println("  - Операций в конце списка");

        System.out.println("\nLinkedList лучше для:");
        System.out.println("  - Частых вставок/удалений в начале списка");
        System.out.println("  - Операций в середине больших коллекций");
        System.out.println("  - Когда важнее скорость вставки, чем скорость доступа");
    }

    // Внутренний класс для хранения результатов
    private static class PerformanceResults {
        long addTime;
        long insertBeginningTime;
        long insertMiddleTime;
        long accessTime;
        long searchTime;
        long removeBeginningTime;
        long removeMiddleTime;

        public PerformanceResults(long addTime, long insertBeginningTime, long insertMiddleTime,
                                  long accessTime, long searchTime, long removeBeginningTime, long removeMiddleTime) {
            this.addTime = addTime;
            this.insertBeginningTime = insertBeginningTime;
            this.insertMiddleTime = insertMiddleTime;
            this.accessTime = accessTime;
            this.searchTime = searchTime;
            this.removeBeginningTime = removeBeginningTime;
            this.removeMiddleTime = removeMiddleTime;
        }

        public void printResults(String listName) {
            System.out.printf("  Добавление в конец: %,d нс%n", addTime);
            System.out.printf("  Вставка в начало: %,d нс%n", insertBeginningTime);
            System.out.printf("  Вставка в середину: %,d нс%n", insertMiddleTime);
            System.out.printf("  Доступ по индексу: %,d нс%n", accessTime);
            System.out.printf("  Поиск элемента: %,d нс%n", searchTime);
            System.out.printf("  Удаление из начала: %,d нс%n", removeBeginningTime);
            System.out.printf("  Удаление из середины: %,d нс%n", removeMiddleTime);
            System.out.println();
        }
    }
}