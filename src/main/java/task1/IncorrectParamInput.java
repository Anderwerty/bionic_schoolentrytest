package task1;

/**
 * Created by admin on 01.06.2017.
 */
public class IncorrectParamInput extends Exception {
    public IncorrectParamInput() {
    }

    public IncorrectParamInput(String message) {
        super(message);
    }
}
