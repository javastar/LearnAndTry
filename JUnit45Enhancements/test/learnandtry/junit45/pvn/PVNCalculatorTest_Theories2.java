package learnandtry.junit45.pvn;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(Theories.class)
public class PVNCalculatorTest_Theories2 {

    private PVNCalculator calculator = new PVNCalculator();

    private static Object[] createTestCase(Integer year, Double income, Double tax) {
        return new Object[]{year, income, tax};
    }

    @DataPoints
    public static Object[] testData() {
        return new Object[] {createTestCase(2000, 1000D, 180D),
                             createTestCase(2009, 1000D, 180D),
                             new Object[]{2010, 1000D, 210D},
                             new Object[]{2011, 1000D, 210D}
        };
    }

    @Theory
    public void testCalculate(Object[] testData) {
        double realTax = calculator.calculate((Integer)testData[0], (Double)testData[1]);
        assertEquals(testData[2], realTax);
    }

}
