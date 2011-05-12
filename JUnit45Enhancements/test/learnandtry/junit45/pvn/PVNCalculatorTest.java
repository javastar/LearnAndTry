package learnandtry.junit45.pvn;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PVNCalculatorTest {

    private PVNCalculator calculator = new PVNCalculator();

    @Test
    public void calculateTest_Before2010() {
        int year = 2000;
        double income = 1000;
        double pvn = calculator.calculate(year, income);
        assertEquals(180.0, pvn);
    }

    @Test
    public void calculateTest_2010() {
        int year = 2010;
        double income = 1000;
        double pvn = calculator.calculate(year, income);
        assertEquals(210.0, pvn);
    }

    @Test
    public void calculateTest_After2010() {
        int year = 2011;
        double income = 1000;
        double pvn = calculator.calculate(year, income);
        assertEquals(210.0, pvn);
    }

}
