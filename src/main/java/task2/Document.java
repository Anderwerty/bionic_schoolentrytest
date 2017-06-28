package task2;

import task1.IncorrectParamInput;

import java.util.Optional;

/**
 * Class at the top of the hierarchy without taking into account Object.
 */
public class Document {
    protected String title;
    protected String text;

    /**
     * Constructor with parameters to check if parameters are valid.
     * @param title
     * @param text
     * @throws IncorrectParamInput
     */
    public Document(String title, String text) throws IncorrectParamInput {
        this(init(title, text), title, text);
    }

    /**
     * Constructor with parameters to initialize fields.
     * @param isCreat is additional parameter for checking validation.
     * @param title
     * @param text
     */
    private Document(boolean isCreat, String title, String text) {
        this.title = title;
        this.text = text;
    }

    /**
     * Get the value of title variable.
     * @return the name of the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the value of text variable.
     * @return the text.
     */

    public String getText() {
        return text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (!title.equals(document.title)) return false;
        return text.equals(document.text);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }

    private static boolean init(String title, String text) throws IncorrectParamInput {
        Optional.ofNullable(title).orElseThrow(IncorrectParamInput::new);
        Optional.ofNullable(text).orElseThrow(IncorrectParamInput::new);
        return true;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", text='" + text + '\'';

    }

    /**
     * Check if the text or title contains textToFind.
     * @param textToFind
     * @return
     */

    public boolean check(String textToFind) {
        if (text.contains(textToFind)
                || title.contains(textToFind)) return true;
        return false;
    }
}
