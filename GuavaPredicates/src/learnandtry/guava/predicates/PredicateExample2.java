package learnandtry.guava.predicates;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.filter;


// Filter beans by name
public class PredicateExample2 {

    public List<AppBean> getBeansWithName(List<AppBean> beans, String name) {
        Collection<AppBean> filtered = filter(beans, new HasName(name));
        return Lists.newArrayList(filtered);
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

}
