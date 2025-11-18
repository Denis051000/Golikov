package package20;

class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "'}";
    }
}