package package20;

class Calculator {

    public static <T extends Number, U extends Number> double sum(T a, U b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T a, U b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T a, U b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtraction(T a, U b) {
        return a.doubleValue() - b.doubleValue();
    }
}