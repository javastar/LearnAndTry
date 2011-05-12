package learnandtry.junit45.pvn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;


@RunWith(Parameterized.class)
public class PVNCalculatorTest_ParameterizedTest {

    private PVNCalculator calculator = new PVNCalculator();

    private static Object[] createTestCase(Integer year, Double income, Double tax) {
        return new Object[]{year, income, tax};
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                createTestCase(2000, 1000D, 180D),
                createTestCase(2009, 1000D, 180D),
                {2010, 1000D, 210D},
                {2011, 1000D, 210D}
        });
    }

    private int year;
    private double income, expectedPvn;

    public PVNCalculatorTest_ParameterizedTest(int year, double income, double expectedPvn) {
        this.year = year;
        this.income = income;
        this.expectedPvn = expectedPvn;
    }

    @Test
    public void calculateTest() {
        double realPvn = calculator.calculate(year, income);
        assertEquals(expectedPvn, realPvn);
    }

}
