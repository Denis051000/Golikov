package package9;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    @Override //реализация comparable в этом классе.  Сравнение студентов по GPA в порядке убывания
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getGpa(), student1.getGpa());
    }

    //Рекурсивный метод quickSort
    public void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);
            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    //  это элемент в алгоритме быстрой сортировки, относительно которого происходит разделение массива на части.
    private int partition(Student[] students, int low, int high) {
        Student pivot = students[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(students[j], pivot) > 0) {
                i++;
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        return i + 1;
    }

    //метод для быстрой сортировки(разделяет массив относительно "опорного элемента"
    public void quickSort(Student[] students) {
        quickSort(students, 0, students.length - 1);
    }
}