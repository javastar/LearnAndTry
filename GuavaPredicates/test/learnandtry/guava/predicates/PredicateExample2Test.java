package learnandtry.guava.predicates;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.IsEqual.equalTo;


public class PredicateExample2Test extends Assert {

    private PredicateExample2 filter = new PredicateExample2();


    @Test
    public void getBeansWithName() {
        assertBeansWithName(Collections.EMPTY_LIST, "NAME", 0);

        assertBeansWithName(newArrayList(
                new AppBean("NAME_1")
        ), "NAME", 0);

        assertBeansWithName(newArrayList(
                new AppBean("NAME")
        ), "NAME", 1);

        assertBeansWithName(newArrayList(
                new AppBean("NAME"),
                new AppBean("NAME")
        ), "NAME", 2);

        assertBeansWithName(newArrayList(
                new AppBean("NAME_1"),
                new AppBean("NAME_2")
        ), "NAME", 0);

        assertBeansWithName(newArrayList(
                new AppBean("NAME_1"),
                new AppBean("NAME_2")
        ), "NAME_1", 1);
    }

    private void assertBeansWithName(List<AppBean> beans, String name, int expectedSize) {
        List<AppBean> filtered = filter.getBeansWithName(beans, name);
        assertThat(filtered.size(), equalTo(expectedSize));
    }

}
