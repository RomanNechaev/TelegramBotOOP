package first.games.whowantotbeamillionaire;

import first.games.interfaces.IScheme;
import first.games.interfaces.ISchemeLoader;
import first.LineParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MillionaireSchemeLoader implements ISchemeLoader<String, String> {
    private List<MillionaireQuestionForm> questionForms;

    public MillionaireSchemeLoader() {
        initQuestionForms(new LineParser("millionaire_quiz.txt"));
    }

    @Override
    public void load(IScheme<String, String> scheme) {
        shuffleQuestionForms();
        for (var form : questionForms)
            scheme.addState(new MillionaireState(form));
    }

    private void initQuestionForms(LineParser parser) {
        questionForms = new ArrayList<>();
        var lines = parser.getLines();
        for (var i = 0; i < lines.size(); i += 5)
        {
            String correctAnswer = null;
            var selection = new ArrayList<String>();
            for (var j = 1; j < 5; j++)
                if (lines.get(i + j).startsWith("+"))
                    correctAnswer = lines.get(i + j).substring(1);
                else
                    selection.add(lines.get(i + j));
            selection.add(correctAnswer);
            questionForms.add(new MillionaireQuestionForm(lines.get(i), correctAnswer, selection));
        }
    }

    private void shuffleQuestionForms() {
        var random = new Random();
        for (var i = questionForms.size() - 1; i > 0; i--)
        {
            var index = random.nextInt(i + 1);
            var el = questionForms.get(index);
            questionForms.set(index, questionForms.get(i));
            questionForms.set(i, el);
        }
    }
}
