package learnandtry.guava.predicates.documents;

import java.util.List;


public class DocumentNameMaxLengthRule {

    public static final int DOCUMENT_MAX_LENGTH = 100;

    public void apply(ErrorContainer errorContainer, DocumentModel model) {
        List<Document> documents = model.getDocuments();
        for(int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            if(document.isSelected()) {
                String title = document.getTitle();
                if(title != null && title.length() > DOCUMENT_MAX_LENGTH) {
                    errorContainer.addError(i);
                }
            }
        }
    }

}
