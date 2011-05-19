package learnandtry.junit45.pvn;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class PVNCalculatorTest_TheoryAlternative {

    private PVNCalculator calculator = new PVNCalculator();


    @Test
    public void testCalculate() {
        assertCalculate(2000, 1000D, 180D);
        assertCalculate(2009, 1000D, 180D);
        assertCalculate(2010, 1000D, 210D);
        assertCalculate(2011, 1000D, 210D);
    }

    private void assertCalculate(int year, double income, double tax) {
        double realTax = calculator.calculate(year, income);
        assertEquals(tax, realTax);
    }

}
