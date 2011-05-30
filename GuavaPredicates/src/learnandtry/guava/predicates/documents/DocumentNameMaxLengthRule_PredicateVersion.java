package learnandtry.guava.predicates.documents;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import java.util.List;

public class DocumentNameMaxLengthRule_PredicateVersion {

    public static final int DOCUMENT_MAX_LENGTH = 100;
    private static final Predicate<Document> conditions =
            Predicates.and(new IsSelected(), new DocumentNameMaxLength());


    public void apply(ErrorContainer errorContainer, DocumentModel model) {
        List<Document> documents = model.getDocuments();
        for(int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            if(conditions.apply(document)) {
                errorContainer.addError(i);
            }
        }
    }


    private static class IsSelected implements Predicate<Document> {
        public boolean apply(Document document) {
            return document.isSelected();
        }
    }

    private static class DocumentNameMaxLength implements Predicate<Document> {
        public boolean apply(Document document) {
            String title = document.getTitle();
            return title != null && title.length() > DOCUMENT_MAX_LENGTH;
        }
    }

}
