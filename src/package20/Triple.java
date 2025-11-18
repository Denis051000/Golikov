package package20;

class Triple<T extends Comparable<T>, V extends Animal, K extends Number> {
    private T first;
    private V second;
    private K third;

    public Triple(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }

    public void printClassNames() {
        System.out.println("T class: " + first.getClass().getSimpleName());
        System.out.println("V class: " + second.getClass().getSimpleName());
        System.out.println("K class: " + third.getClass().getSimpleName());
    }
}