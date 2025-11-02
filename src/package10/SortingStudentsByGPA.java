package package10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingStudentsByGPA {
    private Student[] iDNumber;

    // Конструктор
    public SortingStudentsByGPA() {
        this.iDNumber = new Student[0];
    }

    // 1. Метод заполнения массива
    public void setArray(Student[] students) {
        this.iDNumber = Arrays.copyOf(students, students.length);
    }

    public void setArray(List<Student> students) {
        this.iDNumber = students.toArray(new Student[0]);
    }

    // 2. Методы сортировки

    // Быстрая сортировка по среднему баллу (убывание)
    public void quicksort() {
        if (iDNumber.length > 0) {
            quicksort(0, iDNumber.length - 1, new GradeComparator());
        }
    }

    // Обобщенная быстрая сортировка с компаратором
    private void quicksort(int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quicksort(low, pi - 1, comparator);
            quicksort(pi + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<Student> comparator) {
        Student pivot = iDNumber[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(iDNumber[j], pivot) > 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // Сортировка слиянием по среднему баллу (убывание)
    public void mergeSort() {
        if (iDNumber.length > 0) {
            iDNumber = mergeSort(iDNumber, new GradeComparator());
        }
    }

    private Student[] mergeSort(Student[] array, Comparator<Student> comparator) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        Student[] left = Arrays.copyOfRange(array, 0, mid);
        Student[] right = Arrays.copyOfRange(array, mid, array.length);

        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);

        return merge(left, right, comparator);
    }

    private Student[] merge(Student[] left, Student[] right, Comparator<Student> comparator) {
        Student[] result = new Student[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) > 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    // 3. Метод для вывода массива
    public void outArray() {
        System.out.println("Список студентов:");
        System.out.println("-----------------------------------------------------------------------------");
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println((i + 1) + ". " + iDNumber[i]);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    // 4. Методы сортировки по другим полям

    public void sortByLastName() {
        if (iDNumber.length > 0) {
            quicksort(0, iDNumber.length - 1, new LastNameComparator());
        }
    }

    public void sortByCourse() {
        if (iDNumber.length > 0) {
            quicksort(0, iDNumber.length - 1, new CourseComparator());
        }
    }

    public void sortBySpecialty() {
        if (iDNumber.length > 0) {
            quicksort(0, iDNumber.length - 1, new SpecialtyComparator());
        }
    }

    // Вспомогательный метод для обмена элементов
    private void swap(int i, int j) {
        Student temp = iDNumber[i];
        iDNumber[i] = iDNumber[j];
        iDNumber[j] = temp;
    }

    // Геттер для массива (для задания 3)
    public Student[] getArray() {
        return Arrays.copyOf(iDNumber, iDNumber.length);
    }

    // Компараторы

    // Компаратор по среднему баллу (убывание)
    private static class GradeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
        }
    }

    // Компаратор по фамилии (возрастание)
    private static class LastNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getLastName().compareTo(s2.getLastName());
        }
    }

    // Компаратор по курсу (убывание)
    private static class CourseComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s2.getCourse(), s1.getCourse());
        }
    }

    // Компаратор по специальности (возрастание)
    private static class SpecialtyComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getSpecialty().compareTo(s2.getSpecialty());
        }
    }

    // Главный метод
    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        // Создание тестовых данных
        Student[] students1 = {
                new Student("Иван", "Петров", "Информатика", 3, "ИНБО-21-23", 4.2),
                new Student("Мария", "Иванова", "Математика", 2, "ИСБО-24", 4.8),
                new Student("Алексей", "Сидоров", "Физика", 1, "ККБО-11-25", 3.9),
                new Student("Ольга", "Кузнецова", "Информатика", 1, "ИСБО-22-25", 4.5),
                new Student("Дмитрий", "Смирнов", "Математика", 4, "МТ-10-22", 4.1)
        };

        // Задание 2: Тестирование сортировок

        System.out.println("=== ЗАДАНИЕ 2 ===");

        // Заполнение массива
        sorter.setArray(students1);
        System.out.println("Исходный массив:");
        sorter.outArray();

        // Сортировка быстрой сортировкой по среднему баллу
        System.out.println("\nПосле быстрой сортировки по среднему баллу (убывание):");
        sorter.quicksort();
        sorter.outArray();

        // Сортировка по фамилии
        System.out.println("\nПосле сортировки по фамилии (возрастание):");
        sorter.sortByLastName();
        sorter.outArray();

        // Сортировка по курсу
        System.out.println("\nПосле сортировки по курсу (убывание):");
        sorter.sortByCourse();
        sorter.outArray();

        // Сортировка слиянием по среднему баллу
        System.out.println("\nПосле сортировки слиянием по среднему баллу (убывание):");
        sorter.mergeSort();
        sorter.outArray();

        // Задание 3: Объединение двух списков
        System.out.println("\n=== ЗАДАНИЕ 3 ===");

        // Второй список студентов
        Student[] students2 = {
                new Student("Елена", "Волкова", "Химия", 2, "ИКБО-11-25", 4.3),
                new Student("Сергей", "Комаров", "Информатика", 3, "ИВБО-12-24", 4.7),
                new Student("Анна", "Лебедева", "Физика", 2, "БББО-20-23", 4.0)
        };

        // Объединение и сортировка двух списков
        Student[] mergedList = mergeStudentLists(sorter.getArray(), students2);

        System.out.println("Объединенный список после сортировки:");
        SortingStudentsByGPA mergedSorter = new SortingStudentsByGPA();
        mergedSorter.setArray(mergedList);
        mergedSorter.mergeSort();
        mergedSorter.outArray();
    }

    // Задание 3: Метод для объединения двух списков
    public static Student[] mergeStudentLists(Student[] list1, Student[] list2) {
        Student[] merged = new Student[list1.length + list2.length];
        System.arraycopy(list1, 0, merged, 0, list1.length);
        System.arraycopy(list2, 0, merged, list1.length, list2.length);
        return merged;
    }
}