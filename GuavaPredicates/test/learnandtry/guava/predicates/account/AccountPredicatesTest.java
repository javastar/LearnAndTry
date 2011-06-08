package learnandtry.guava.predicates.account;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.transform;
import static junit.framework.Assert.assertEquals;


public class AccountPredicatesTest {

    private List<Account> accounts = Arrays.asList(
            createAccount(1L, Region.ASIA, Status.ACTIVE),
            createAccount(2L, Region.ASIA, Status.CLOSED),

            createAccount(3L, Region.EUROPE, Status.ACTIVE),
            createAccount(4L, Region.EUROPE, Status.CLOSED),

            createAccount(5L, Region.UK, Status.ACTIVE),
            createAccount(6L, Region.UK, Status.CLOSED),

            createAccount(7L, Region.LATIN_AMERICA, Status.ACTIVE),
            createAccount(8L, Region.NORTH_AMERICA, Status.CLOSED)
    );


    private Account createAccount(Long pk, Region region, Status status) {
        Account account = new Account();
        account.setPk(pk);
        account.setRegion(region);
        account.setStatus(status);
        return account;
    }

    private List<Long> getAccountPks(List<Account> accounts) {
        return transform(accounts, new PkFunction());
    }

    public class PkFunction implements Function<Account, Long> {
        public Long apply(Account account) {
            return account.getPk();
        }
    }


    @Test  // Please use this test method as a template for your Predicate tests
    public void assertExample() {
        List<Account> actualList = Lists.newArrayList(); // define your logic here
        List<Long> expectedPks = Lists.newArrayList(1L, 2L);

        assertEquals(getAccountPks(actualList), expectedPks);
    }

}
