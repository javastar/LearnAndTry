package learnandtry.junit45.question;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(Theories.class)
public class EmptyQuestionConditionTest {

    private EmptyQuestionCondition condition = new EmptyQuestionCondition();

    @DataPoints
    public static Object[] testData() {
        return new Object[] {new Object[]{AnswerType.CHECHBOX, null, true},
                             new Object[]{AnswerType.CHECHBOX, "false", true},
                             new Object[]{AnswerType.CHECHBOX, "true", false},
                             new Object[]{AnswerType.FREE_TEXT, null, true},
                             new Object[]{AnswerType.FREE_TEXT, "", true},
                             new Object[]{AnswerType.FREE_TEXT, "text", false}
        };
    }

    @Theory
    public void testCalculate(Object[] testData) {
        Question question = new Question();
        question.setAnswerType((AnswerType) testData[0]);
        question.setAnswer((String) testData[1]);

        boolean isEmpty = condition.isQuestionEmpty(question);
        assertEquals(testData[2], isEmpty);
    }

}
