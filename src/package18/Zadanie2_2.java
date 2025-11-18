package package18;
import java.util.Scanner;
public class Zadanie2_2 {
    public static void main(String[] args) {
        exceptionDemo();
    }
    public static void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in);
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        int i = Integer.parseInt(intString);
        System.out.println( 2/i );
    }
}
//"Qwerty": NumberFormatException - невозможно преобразовать строку в число
//"0": ArithmeticException: / by zero - деление на ноль
//"1.2": NumberFormatException - дробное число при ожидании целого
//"1": Успешное выполнение, результат: 2