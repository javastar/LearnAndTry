package learnandtry.guava.predicates;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.IsEqual.equalTo;


public class PredicateExample1Test extends Assert {

    private PredicateExample1 filter = new PredicateExample1();


    @Test
    public void getEnabledBeans() {
        assertEnabledBeans(Collections.EMPTY_LIST, 0);

        assertEnabledBeans(newArrayList(
                new AppBean(Boolean.TRUE)
        ), 1);

        assertEnabledBeans(newArrayList(
                new AppBean(Boolean.FALSE)
        ), 0);

        assertEnabledBeans(newArrayList(
                new AppBean(Boolean.FALSE),
                new AppBean(Boolean.FALSE)
        ), 0);

        assertEnabledBeans(newArrayList(
                new AppBean(Boolean.TRUE),
                new AppBean(Boolean.TRUE)
        ), 2);

        assertEnabledBeans(newArrayList(
                new AppBean(Boolean.TRUE),
                new AppBean(Boolean.FALSE)
        ), 1);
    }

    private void assertEnabledBeans(List<AppBean> beans, int expectedSize) {
        List<AppBean> filtered = filter.getEnabledBeans_OldWay(beans);
        assertThat(filtered.size(), equalTo(expectedSize));

        filtered = filter.getEnabledBeans_GuavaWay(beans);
        assertThat(filtered.size(), equalTo(expectedSize));
    }

}
