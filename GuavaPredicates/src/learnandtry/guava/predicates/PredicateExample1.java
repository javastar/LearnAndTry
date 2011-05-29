package learnandtry.guava.predicates;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.filter;


// Filter enabled beans
public class PredicateExample1 {

    public List<AppBean> getEnabledBeans_OldWay(List<AppBean> beans) {
        List<AppBean> filtered = new ArrayList<AppBean>();
        for(AppBean bean : beans) {
            if(bean.isEnabled()) {
                filtered.add(bean);
            }
        }
        return filtered;
    }


    // New way use
    public List<AppBean> getEnabledBeans_GuavaWay(List<AppBean> beans) {
        Collection<AppBean> filtered = filter(beans, new IsEnabled());
        return Lists.newArrayList(filtered);
    }

    private static class IsEnabled implements Predicate<AppBean> {
        public boolean apply(AppBean appBean) {
            return appBean.isEnabled();
        }
    }

}
