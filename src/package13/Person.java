package package13;

public class Person {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName);
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(firstName.charAt(0)).append(".");
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (sb.length() > 0) sb.append("");
            sb.append(middleName.charAt(0)).append(".");
        }

        return sb.toString();
    }

    // Тестовый метод
    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иванович");
        Person person2 = new Person("Петров", "Петр", null);
        Person person3 = new Person("Сидоров", null, null);

        System.out.println(person1.getFullName()); // Иванов И.И.
        System.out.println(person2.getFullName()); // Петров П.
        System.out.println(person3.getFullName()); // Сидоров
    }
}