package package18;
public class Zadanie1_2 {
    public static void main(String[] args) {
        exceptionDemo();
    }
    public static void exceptionDemo() {
        System.out.println(2.0 / 0.0);
    }
}
//При делении на ноль в арифметике с плавающей точкой результатом будет Infinity, а не исключение.