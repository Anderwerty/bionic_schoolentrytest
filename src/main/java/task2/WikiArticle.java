package task2;

import task1.IncorrectParamInput;

/**
 * Created by admin on 07.06.2017.
 */
public class WikiArticle extends Document {
    private String link;

    /**
     * Constructor with parameters.
     * @param title
     * @param text
     * @param link
     * @throws IncorrectParamInput
     */
    public WikiArticle(String title, String text, String link) throws IncorrectParamInput {
        super(title, text);
        this.link = link;
    }

    /**
     * Get the value of link variable.
     * @return the link.
     */
    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WikiArticle that = (WikiArticle) o;

        return link != null ? link.equals(that.link) : that.link == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WikiArticle{" +
                super.toString()+
                "link='" + link + '\'' +
                '}';
    }
}
