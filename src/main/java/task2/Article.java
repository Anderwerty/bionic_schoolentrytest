package task2;

import task1.IncorrectParamInput;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 01.06.2017.
 */
public class Article extends Document {

    private List<String> authors;
    private Journal journal;
    private int year;
    private int number;

    /**
     * Constructor with parameters to check if parameters are valid.
     * @param title
     * @param text
     * @param authors
     * @param journal
     * @param year
     * @param number
     * @throws IncorrectParamInput
     */
    public Article(String title, String text, List<String> authors,
                   Journal journal, int year, int number) throws IncorrectParamInput {
        this(init(authors,journal,year),title,text,authors,journal,year,number);


    }

    /**
     * Constructor with parameters to initialize fields.
     * @param isCreat is additional parameter for validation
     * @param title
     * @param text
     * @param authors
     * @param journal
     * @param year
     * @param number
     * @throws IncorrectParamInput
     */

    private Article(boolean isCreat,String title, String text, List<String> authors,
                   Journal journal, int year, int number) throws IncorrectParamInput {
        super(title, text);
        this.authors = authors;
        this.journal = journal;
        this.year = year;
        this.number = number;
    }

    /**
     * Method for validation.
     * @param authors
     * @param journal
     * @param year
     * @return
     * @throws IncorrectParamInput if {@param authors}or {@param journal}
     */
    private static boolean init(List<String> authors,Journal journal,int year)
            throws IncorrectParamInput {
        Optional.ofNullable(authors).orElseThrow(IncorrectParamInput::new);
        Optional.ofNullable(journal).orElseThrow(IncorrectParamInput::new);
        if(year<1800||year> Calendar.getInstance().get(Calendar.YEAR))
            throw new IncorrectParamInput("invalid year of publication");
       return true;

    }

    /**
     * Get the value of authors variable.
     * @return the list of authors.
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * Get the value of journal variable.
     * @return the name of journal.
     */

    public Journal getJournal() {
        return journal;
    }

    /**
     * Get the value of year variable.
     * @return the year of publication.
     */

    public int getYear() {
        return year;
    }

    /**
     * Get the value of number variable.
     * @return the number.
     */

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Article article = (Article) o;

        if (year != article.year) return false;
        if (number != article.number) return false;
        if (!authors.equals(article.authors)) return false;
        return journal == article.journal;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + journal.hashCode();
        result = 31 * result + year;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                super.toString()+
                ",authors=" + authors +
                ", journal=" + journal +
                ", year=" + year +
                ", number=" + number +
                '}';
    }
}

