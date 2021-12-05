package first.games.whowantotbeamillionaire;

import lombok.Getter;

import java.util.List;

public class MillionaireQuestionForm {
    @Getter
    private final String question;
    @Getter
    private final String correctAnswer;
    @Getter
    private final List<String> selection;

    public MillionaireQuestionForm(String question, String correctAnswer, List<String> selection) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.selection = selection;
    }
}
