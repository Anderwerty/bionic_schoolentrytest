package task3;

import static java.lang.Math.pow;

/**
 * Class Square extends from class {@link Shape}.
 */
public class Square extends Shape {
    private double side;

    /**
     * Constructor with parameter.
     * @param side
     */

    private Square(double side) {
        this.side = side;
    }

    /**
     * Factory method.
     * @param side
     * @return
     * @throws IllegalArgumentInputException if side is not positive.
     */
    public static Square getInsteance(double side) throws IllegalArgumentInputException {
        validator(side);
        return  new Square(side);
    }

    /**
     * Get the value of side variable.
     * @return length of side.
     */
    public double getSide() {
        return side;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(side);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public double getArea() {
        return pow(side,2);
    }
}
