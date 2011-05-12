package learnandtry.junit45.question;


public class EmptyQuestionCondition {

    public boolean isQuestionEmpty(Question question) {
        return checkboxCondition(question)
                || freetextCondition(question);
    }

    private boolean checkboxCondition(Question question) {
        return AnswerType.CHECHBOX.equals(question.getAnswerType())
                && (isAnswerEmpty(question) || ("false".equalsIgnoreCase(question.getAnswer())));
    }

    private boolean freetextCondition(Question question) {
        return AnswerType.FREE_TEXT.equals(question.getAnswerType())
                && isAnswerEmpty(question);
    }

    private boolean isAnswerEmpty(Question question) {
        String answer = question.getAnswer();
        return (answer == null) || (answer.isEmpty());
    }

}
