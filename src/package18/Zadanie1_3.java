package package18;

public class Zadanie1_3 {
    public static void main(String[] args) {
        exceptionDemo();
    }
    public static void exceptionDemo() {
        try{
            System.out.println( 2/0 );
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }
}
//Исключение перехватывается блоком catch, программа не "падает" и выводит сообщение об ошибке.