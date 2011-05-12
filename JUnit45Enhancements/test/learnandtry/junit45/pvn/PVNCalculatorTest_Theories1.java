package learnandtry.junit45.pvn;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(Theories.class)
public class PVNCalculatorTest_Theories1 {

    private PVNCalculator calculator = new PVNCalculator();

    private static Object[] createTestCase(Integer year, Double income, Double tax) {
        return new Object[]{year, income, tax};
    }

    @DataPoint public static Object[] testData1 = createTestCase(2000, 1000D, 180D);
    @DataPoint public static Object[] testData2 = createTestCase(2009, 1000D, 180D);
    @DataPoint public static Object[] testData3 = new Object[] {2010, 1000D, 210D};
    @DataPoint public static Object[] testData4 = new Object[] {2011, 1000D, 210D};


    @Theory
    public void testCalculate(Object[] testData) {
        double realTax = calculator.calculate((Integer)testData[0], (Double)testData[1]);
        assertEquals(testData[2], realTax);
    }

}
