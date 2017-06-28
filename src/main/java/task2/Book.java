package task2;

import task1.IncorrectParamInput;

import java.util.List;

/**
 * Class Book
 */
public class Book extends Document {
    private List<String> authors;
    private Publisher publisher;
    private String annotation;


    /**
     *  Constructor with parameters initialize fields.
     * @param title
     * @param text
     * @param authors
     * @param publisher
     * @param annotation
     * @throws IncorrectParamInput
     */
    public Book(String title, String text, List<String> authors,
                Publisher publisher, String annotation) throws IncorrectParamInput {
        super(title, text);
        this.authors = authors;
        this.publisher = publisher;
        this.annotation = annotation;
    }

    /**
     * Get the value of authors variable.
     * @return the list of authors.
     */
    public List<String> getAuthors() {
        return authors;
    }


    /**
     * Get the value of the publisher variable.
     * @return the name of publisher.
     */
    public Publisher getPublisher() {
        return publisher;
    }


    /**
     * Get the value of the annotation variable.
     * @return the annotation.
     */
    public String getAnnotation() {
        return annotation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (!authors.equals(book.authors)) return false;
        if (publisher != book.publisher) return false;
        return annotation.equals(book.annotation);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + annotation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                super.toString()+
                "authors=" + authors +
                ", publisher=" + publisher +
                ", annotation='" + annotation + '\'' +
                '}';
    }
}
