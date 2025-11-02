package package11;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Задание 3: Класс Student с датой рождения
 */
public class Student {
    private String name;
    private String surname;
    private Date birthDate;

    public Student(String name, String surname, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    // Метод для форматированного вывода даты рождения
    public String getFormattedBirthDate(String formatType) {
        SimpleDateFormat formatter;

        switch (formatType.toLowerCase()) {
            case "short":
                formatter = new SimpleDateFormat("dd.MM.yy");
                break;
            case "medium":
                formatter = new SimpleDateFormat("dd MMM yyyy");
                break;
            case "full":
                formatter = new SimpleDateFormat("EEEE, d MMMM yyyy 'г.'");
                break;
            case "iso":
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                break;
            default:
                formatter = new SimpleDateFormat("dd.MM.yyyy");
        }
        return formatter.format(birthDate);
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', surname='%s', birthDate=%s}",
                name, surname, getFormattedBirthDate("default"));
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
}