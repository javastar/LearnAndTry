package learnandtry.junit45.pvn;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(Theories.class)
public class PVNCalculatorTest_Theories4 {

    private PVNCalculator calculator = new PVNCalculator();

    @DataPoints
    public static Object[] testData() {
        return new Object[]{
                    new TestData(2000, 1000D, 180D),
                    new TestData(2009, 1000D, 180D),
                    new TestData(2010, 1000D, 210D),
                    new TestData(2011, 1000D, 210D)
        };
    }

    @Theory
    public void testCalculate(TestData testData) {
        double realTax = calculator.calculate(testData.year, testData.income);
        assertEquals(testData.tax, realTax);
    }


    private static class TestData {
        public Integer year;
        public Double income;
        public Double tax;

        private TestData(Integer year, Double income, Double tax) {
            this.year = year;
            this.income = income;
            this.tax = tax;
        }
    }

}
