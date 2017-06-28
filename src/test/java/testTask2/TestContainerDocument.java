package testTask2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import task1.IncorrectParamInput;
import task2.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 07.06.2017.
 */
public class TestContainerDocument {

    public ContainerDocument container;

    @After
    public void clean() {
        container = null;
    }

    @Test(expected = IncorrectParamInput.class)
    public void nullArgumentInput() throws IncorrectParamInput {
        Document[] documents = null;
        container = ContainerDocument.getInsteance(documents);
    }

    @Test
    public void numberCoincidences() throws IncorrectParamInput {
        String articleText = "Java is a general-purpose computer" +
                " programming language that is concurrent, class-based," +
                " object-oriented, and specifically designed to have as few" +
                " implementation dependencies as possible. It is intended to" +
                " let application developers \"write once, run anywhere\" (WORA)," +
                " meaning that compiled Java code can run on " +
                "all platforms that support Java without the need for recompilation.";
        String articleTitle = "Java";
        List<String> authoursArticle = new ArrayList<>();
        authoursArticle.add("Shild");
        Article article = new Article(articleTitle, articleText, authoursArticle, Journal.VISNIK, 2017, 12);
        String bookText = "We went through that chapter multiple times, consulting with several" +
                " people who wrote the specs and are otherwise experts. We were only able" +
                " to cover the highest level in the book, and it's still pretty hard to understand" +
                " (although David exceeded himself in making it as comprehensible " +
                "as possible)\n" +
                "Learning to use generified types can get very complicated. " +
                "It's hard to understand why you cannot do some things without" +
                " casts, for example. But writing generified classes is rocket " +
                "science. Here's one that showed up at the very last minute: " +
                "It's a bad idea to declare a type that returns an array of a" +
                " type parameter.";
        String bookTitle = "Generics in Java";
        List<String> authoursBook = new ArrayList<>();
        authoursBook.add("Shild");
        Book book = new Book(bookTitle, bookText, authoursBook, Publisher.EKSMO, "Good day");
        WikiArticle wikiArticle=new WikiArticle("Dog","Good dogs","https://dogs/");

        Document[] documents = {article, book,wikiArticle};
        container=ContainerDocument.getInsteance(documents);

        int actual= container.numberCoincidences("Java");
        int expected=2;
        Assert.assertEquals(expected,actual,0);
    }
}
