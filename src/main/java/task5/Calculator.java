package task5;

/**
 * Created by admin on 1.06.2017.
 */
public class Calculator {
    /**
     * Functional interface.
     */
    interface IntegerMath {
        /**
         * Method with two parameters.
         * @param a
         * @param b
         * @return
         */
        int operation(int a, int b);
    }

    /**
     * Mathod with three parameters.
     * For the object IntegerMath the method {@link IntegerMath#operation(int, int)}
     * is called.
     * @param a
     * @param b
     * @param op
     * @return the result of method {@link IntegerMath#operation(int, int)}
     */
    public int operateBinary(int a, int b,IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {
        Calculator myApp = new Calculator();
        /**
         *  Instances of an anonymous class that implement the interface {@link IntegerMath}.
         *  Used lambda functions.
         */

        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +  myApp.operateBinary(20, 10, subtraction));
    }

}
