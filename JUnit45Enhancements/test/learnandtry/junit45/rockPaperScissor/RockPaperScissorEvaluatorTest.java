package learnandtry.junit45.rockPaperScissor;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(Theories.class)
public class RockPaperScissorEvaluatorTest {

    private RockPaperScissorEvaluator evaluator = new RockPaperScissorEvaluator();

    private static Object[] createTestCase(Hand hand1, Hand hand2, Integer result) {
        return new Object[] {hand1, hand2, result};
    }

    @DataPoints
    public static Object[] testData() {
        return new Object[] {
                createTestCase(Hand.ROCK, Hand.ROCK, 0),
                createTestCase(Hand.PAPER, Hand.ROCK, 1),
                createTestCase(Hand.SCISSOR, Hand.ROCK, -1),
                createTestCase(Hand.PAPER, Hand.PAPER, 0),
                createTestCase(Hand.PAPER, Hand.ROCK, 1),
                new Object[]{Hand.PAPER, Hand.SCISSOR, -1},
                new Object[]{Hand.SCISSOR, Hand.SCISSOR, 0},
                new Object[]{Hand.SCISSOR, Hand.PAPER, 1},
                new Object[]{Hand.SCISSOR, Hand.ROCK, -1}
        };
    }

    @Theory
    public void evaluate(Object[] testData) throws Exception {
        int result = evaluator.evaluate((Hand)testData[0], (Hand)testData[1]);
        assertEquals(testData[2], result);
    }

}
