package learnandtry.guava.predicates;


import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

import static com.google.common.base.Predicates.and;
import static com.google.common.collect.Collections2.filter;


// Filter enabled beans by name
public class PredicateExample3_CompositePredicate {

    public List<AppBean> getEnabledBeansWithName(List<AppBean> beans, String name) {
        Predicate<AppBean> conditions = and(isEnabled(),
                                            hasName(name));

        Collection<AppBean> filtered = filter(beans, conditions);
        return Lists.newArrayList(filtered);
    }


    private static HasName hasName(String name) {
        return new HasName(name);
    }

    private static class HasName implements Predicate<AppBean> {
        private String name;

        private HasName(String name) {
            this.name = name;
        }

        public boolean apply(AppBean appBean) {
            String beanName = appBean.getName();
            return name.equals(beanName);
        }
    }


    private static IsEnabled isEnabled() {
        return new IsEnabled();
    }

    private static class IsEnabled implements Predicate<AppBean> {
        public boolean apply(AppBean appBean) {
            return appBean.isEnabled();
        }
    }

}
