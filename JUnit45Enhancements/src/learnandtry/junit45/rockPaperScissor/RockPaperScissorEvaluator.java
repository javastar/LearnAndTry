package learnandtry.junit45.rockPaperScissor;


public class RockPaperScissorEvaluator {

    public Integer evaluate(Hand side1, Hand side2) {
        if (side1.equals(Hand.ROCK) && !side2.equals(Hand.ROCK)) {
            return (side2.equals(Hand.SCISSOR)) ? 1 : -1;
        } else if (side1.equals(Hand.SCISSOR) && !side2.equals(Hand.SCISSOR)) {
            return (side2.equals(Hand.PAPER)) ? 1 : -1;
        } else if (side1.equals(Hand.PAPER) && !side2.equals(Hand.PAPER)) {
            return (side2.equals(Hand.ROCK)) ? 1 : -1;
        }

        return 0;
    }

}
