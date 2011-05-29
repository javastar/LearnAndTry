package learnandtry.guava.predicates;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.IsEqual.equalTo;


public class PredicateExample3_CompositePredicateTest extends Assert {

    private PredicateExample3_CompositePredicate filter = new PredicateExample3_CompositePredicate();


    @Test
    public void getEnabledBeansWithName() {
        assertEnabledBeansWithName(Collections.EMPTY_LIST, "NAME", 0);

        assertEnabledBeansWithName(newArrayList(
                new AppBean("NAME_1", Boolean.TRUE)
        ), "NAME", 0);

        assertEnabledBeansWithName(newArrayList(
                new AppBean("NAME", Boolean.FALSE)
        ), "NAME", 0);

        assertEnabledBeansWithName(newArrayList(
                new AppBean("NAME", Boolean.TRUE)
        ), "NAME", 1);

        assertEnabledBeansWithName(newArrayList(
                new AppBean("NAME", Boolean.TRUE),
                new AppBean("NAME", Boolean.TRUE)
        ), "NAME", 2);

        assertEnabledBeansWithName(newArrayList(
                new AppBean("NAME", Boolean.FALSE),
                new AppBean("NAME", Boolean.FALSE)
        ), "NAME", 0);

        assertEnabledBeansWithName(newArrayList(
                new AppBean("NAME", Boolean.TRUE),
                new AppBean("NAME", Boolean.FALSE)
        ), "NAME", 1);
    }

    private void assertEnabledBeansWithName(List<AppBean> beans, String name, int expectedSize) {
        List<AppBean> filtered = filter.getEnabledBeansWithName(beans, name);
        assertThat(filtered.size(), equalTo(expectedSize));
    }

}
