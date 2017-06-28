package task3;

/**
 * Class Rectangle extends class {@link Shape}
 */
public class Rectangle extends Shape {

    private double a;
    private double b;


    /**
     * Constructor with parameters.
     *
     * @param a
     * @param b
     */
    private Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Factory method.
     *
     * @param a
     * @param b
     * @return
     * @throws IllegalArgumentInputException
     */

    public static Rectangle getInsteance(double a, double b) throws IllegalArgumentInputException {
        rectangleValidator(a, b);
        return new Rectangle(a, b);
    }

    /**
     * Method for validation.
     *
     * @param a
     * @param b
     * @return
     * @throws IllegalArgumentInputException if a or b not positive.
     */

    private static boolean rectangleValidator(double a, double b)
            throws IllegalArgumentInputException {
        validator(a);
        validator(b);

        return true;
    }

    @Override
    public double getArea() {
        return a * b;
    }
}
