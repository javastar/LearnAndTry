package learnandtry.junit45.withdraw;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;


@RunWith(Theories.class)
public class AccountTest {

    @DataPoints
    public static Object[] testData() {
        return new Object[] {
                new Object[]{new BigDecimal("0"), new BigDecimal("0"), true},
                new Object[]{new BigDecimal("0"), new BigDecimal("1"), false},
                new Object[]{new BigDecimal("10"), new BigDecimal("1"), true},
                new Object[]{new BigDecimal("10"), new BigDecimal("100"), false},
        };
    }

    @Theory
    public void withdraw(Object[] testData) {
        Account account = new Account((BigDecimal) testData[0]);
        boolean result = account.withdraw((BigDecimal) testData[1]);
        assertEquals(testData[2], result);
    }

}
