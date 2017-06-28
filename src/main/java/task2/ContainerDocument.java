package task2;

import task1.IncorrectParamInput;

/**
 * Created by admin on 01.06.2017.
 */
public class ContainerDocument {
    private Document[] documents;

    private ContainerDocument(Document[] documents) {
        this.documents = documents;
    }

    /**
     * Factory method.
     *
     * @param documents
     * @return
     * @throws IncorrectParamInput if {@param documents} is null.
     */
    public static ContainerDocument getInsteance(Document[] documents)
            throws IncorrectParamInput {
        if (documents == null) throw new IncorrectParamInput();
        return new ContainerDocument(documents);
    }

    /**
     * Method to count the number of documents that have textToFind in title or in text.
     *
     * @param textToFind
     * @return
     */
    public int numberCoincidences(String textToFind) {
        int counter = 0;

        for (Document element : documents) {
            if (element.check(textToFind)) {
                counter++;
            }
        }

        return counter;
    }


}
