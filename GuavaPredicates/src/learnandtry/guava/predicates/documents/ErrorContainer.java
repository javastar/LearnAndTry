package learnandtry.guava.predicates.documents;


import com.google.common.collect.Lists;

import java.util.List;

public class ErrorContainer {

    private List<Integer> violatedIndexes = Lists.newArrayList();

    public void addError(int violatedIndex) {
        violatedIndexes.add(violatedIndex);
    }

    public boolean containsIndex(int indexToCheck) {
        return violatedIndexes.contains(indexToCheck);
    }

}
