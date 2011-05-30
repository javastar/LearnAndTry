package learnandtry.guava.predicates.documents;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;


public class DocumentNameMaxLengthRule_PredicateVersionTest extends Assert {

    private static final String SHORT_DOC_NAME = "DOC_NAME";
    private static final String LONG_DOC_NAME = "DOC_NAME_LOOOOOONGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG";

    private DocumentNameMaxLengthRule_PredicateVersion rule = new DocumentNameMaxLengthRule_PredicateVersion();


    @Test
    public void apply() {
        assertApply(Lists.newArrayList(createDocument(false, SHORT_DOC_NAME)), Lists.<Integer>newArrayList());

        assertApply(Lists.newArrayList(createDocument(false, LONG_DOC_NAME)),
                                       Lists.<Integer>newArrayList());

        assertApply(Lists.newArrayList(createDocument(true, SHORT_DOC_NAME)), Lists.<Integer>newArrayList());

        assertApply(Lists.newArrayList(createDocument(true, LONG_DOC_NAME)),
                                       Lists.<Integer>newArrayList(0));

        assertApply(Lists.newArrayList(createDocument(true, LONG_DOC_NAME),
                                       createDocument(true, SHORT_DOC_NAME),
                                       createDocument(true, LONG_DOC_NAME)),
                                       Lists.<Integer>newArrayList(0, 2));

        assertApply(Lists.newArrayList(createDocument(false, LONG_DOC_NAME),
                                       createDocument(true, SHORT_DOC_NAME),
                                       createDocument(true, LONG_DOC_NAME),
                                       createDocument(true, LONG_DOC_NAME)),
                                       Lists.<Integer>newArrayList(2, 3));
    }

    private void assertApply(List<Document> documents, List<Integer> violatedIndexes) {
        ErrorContainer errorContainer = new ErrorContainer();
        DocumentModel model = new DocumentModel();
        model.setDocuments(documents);

        rule.apply(errorContainer, model);

        for(Integer indexToCheck : violatedIndexes) {
            assertThat(errorContainer.containsIndex(indexToCheck), is(true));
        }
    }

    private Document createDocument(boolean selected, String title) {
        Document document = new Document();
        document.setSelected(selected);
        document.setTitle(title);
        return document;
    }

}
