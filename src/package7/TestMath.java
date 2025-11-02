package package7;

public class TestMath {
    public static void main(String[] args) {
        MathCalculable mc = new four();
        System.out.println("Длина окружности: " + ((four) mc).circleLength(5));
        System.out.println("Модуль комплексного числа: " + mc.complexModulus(3, 4));
        System.out.println("Возведение в степень: " + mc.power(2, 3, 2));
    }
}
