package first.games.whowantotbeamillionaire;

import first.games.interfaces.IState;
import first.games.interfaces.IStateResponse;

import java.util.Locale;

public class MillionaireState implements IState<String, String> {
    private final MillionaireQuestionForm questionForm;

    public MillionaireState(MillionaireQuestionForm questionForm) {
        this.questionForm = questionForm;
    }

    @Override
    public IStateResponse<String> execute(String source) {
        var isCorrectAnswer = checkOnCorrectAnswer(questionForm.getCorrectAnswer(), source);
        return new MillionaireStateResponse(
                isCorrectAnswer,
                isCorrectAnswer
                        ? "Красавчик, идём дальше"
                        : "Неверно, правильный ответ - " + questionForm.getCorrectAnswer() + "\nНе грусти, в следущий раз повезёт)"
        );
    }

    private Boolean checkOnCorrectAnswer(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        return s1.strip().toLowerCase(Locale.ROOT).equals(s2.strip().toLowerCase(Locale.ROOT));
    }
}
