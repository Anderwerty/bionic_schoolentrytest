package task3;

import static java.lang.Math.PI;

/**
 * Class Cirle extends class{@link Shape}
 * DO NOT INHERIT FROM CLASS RECTANGLE MEANINGALLY
 */
public class Circle extends Shape {

    private double radius;

    /**
     * Constructor with parameters.
     * @param radius
     */
    private Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Factory method.
     * @param radius
     * @return
     * @throws IllegalArgumentInputException
     * @see {@link Shape#validator(double)}
     */
    public static Circle getInsteance(double radius) throws IllegalArgumentInputException {
        validator(radius);
        return new Circle(radius);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public double getArea() {
        return 2*PI*radius;
    }
}
