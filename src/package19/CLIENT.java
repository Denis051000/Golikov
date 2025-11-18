package package19;

public class CLIENT {
    private String lastName;
    private String firstName;
    private String middleName;
    private String inn;

    public CLIENT(String lastName, String firstName, String middleName, String inn) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.inn = inn;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, ИНН: %s", lastName, firstName, middleName, inn);
    }
}
