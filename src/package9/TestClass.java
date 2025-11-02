package package9;

public class TestClass {

    // Сортировка вставками по ID
    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].getId() > key.getId()) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }
    }

    // Сортировка слиянием для объединения двух списков
    public static Student[] mergeSort(Student[] list1, Student[] list2) {
        Student[] merged = new Student[list1.length + list2.length];

        // Копируем оба массива в один
        System.arraycopy(list1, 0, merged, 0, list1.length);
        System.arraycopy(list2, 0, merged, list1.length, list2.length);

        // Сортируем объединенный массив
        mergeSort(merged, 0, merged.length - 1);

        return merged;
    }

    private static void mergeSort(Student[] students, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);

            merge(students, left, mid, right);
        }
    }

    private static void merge(Student[] students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        System.arraycopy(students, left, leftArray, 0, n1);
        System.arraycopy(students, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        // Тест 1: Создание массива и сортировка вставками по ID
        System.out.println("=== Тест 1: Сортировка вставками по ID ===");
        Student[] students = {
                new Student(5, "Иван", 4.2),
                new Student(2, "Мария", 4.8),
                new Student(8, "Петр", 3.9),
                new Student(1, "Анна", 4.5),
                new Student(4, "Сергей", 3.7)
        };

        System.out.println("Исходный массив:");
        for (Student student : students) {
            System.out.println(student);
        }

        insertionSort(students);

        System.out.println("\nПосле сортировки вставками по ID:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Тест 2: Быстрая сортировка по GPA
        System.out.println("\n=== Тест 2: Быстрая сортировка по GPA ===");

        System.out.println("Исходный массив для сортировки по GPA:");
        for (Student student : students) {
            System.out.println(student);
        }

        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.quickSort(students);

        System.out.println("\nПосле быстрой сортировки по GPA по убыванию:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Тест 3: Объединение двух списков сортировкой слиянием
        System.out.println("\n=== Тест 3: Объединение двух списков сортировкой слиянием ===");
        Student[] list1 = {
                new Student(3, "Елена", 4.1),
                new Student(1, "Федор", 3.8),
                new Student(5, "Галина", 4.3)
        };

        Student[] list2 = {
                new Student(2, "Игорь", 4.0),
                new Student(4, "Жанна", 4.7),
                new Student(6, "Константин", 3.6)
        };

        System.out.println("Первый список:");
        for (Student student : list1) {
            System.out.println(student);
        }

        System.out.println("\nВторой список:");
        for (Student student : list2) {
            System.out.println(student);
        }

        Student[] mergedList = mergeSort(list1, list2);

        System.out.println("\nОбъединенный и отсортированный список:");
        for (Student student : mergedList) {
            System.out.println(student);
        }
    }
}