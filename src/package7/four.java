package package7;

public class four implements MathCalculable {
    @Override public double power(double n, double i, int t) {
        int t_1 = (int)n;
        int t_2 = (int)i;
        int t_3;
        while (t > 1) {
            t_3 = t_1;
            t_1 = t_1 * (int)n - t_2 * (int)i;
            t_2 = t_3 * (int)i + t_2 * (int)n;
            t -= 1;
        }
        return Math.pow(Math.pow(t_1, 2) + Math.pow(t_2, 2), 0.5);
    }

    @Override
    public double complexModulus(double real, double imaginary) {
        return Math.sqrt(real * real + imaginary * imaginary);

    }

    public double circleLength(double radius) {
        return 2 * PI * radius;
    }
}