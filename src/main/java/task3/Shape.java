package task3;

/**
 * Created by admin on 01.06.2017.
 */
public abstract class Shape {

    /**
     * Get the value shape area.
     * @return a area of shape.
     */
    public abstract double getArea();

    /**
     * Method for validation
     * @param side
     * @return
     * @throws IllegalArgumentInputException if {@param side} is not positive.
     */

    static public boolean validator(double side) throws IllegalArgumentInputException {
        if (side <= 0) throw new IllegalArgumentInputException();
        return false;
    }
}
