package package18;
public class Zadanie1_1 {
    public static void main(String[] args) {
        exceptionDemo();
    }
    public static void exceptionDemo() {
        System.out.println(2 / 0);
    }
}
//При выполнении этого кода возникает ArithmeticException: / by zero, потому что деление на ноль в целочисленной арифметике запрещено.