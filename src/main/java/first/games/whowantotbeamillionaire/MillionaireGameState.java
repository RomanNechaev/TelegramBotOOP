package first.games.whowantotbeamillionaire;

import first.IScheme;
import first.ISchemeLoader;
import first.games.IGame;

public class MillionaireGameState implements IGame {
    private final IScheme<String, String> scheme;
    private final ISchemeLoader<String, String> schemeLoader;
    private Integer score;

    public MillionaireGameState()
    {
        scheme = new MillionaireScheme<>();
        schemeLoader = new MillionaireSchemeLoader<>();
    }

    @Override
    public String checkAnswer(String message) {
        var answer = scheme.getCurrentState().getCorrectAnswer();
        if (answer.equals(message))
            return "Красавчик";
        else
            return "Bad boy";
    }

    @Override
    public String getStartMessage() {
        return null;
    }

    @Override
    public void start() {
        schemeLoader.load(scheme);
    }

    @Override
    public String getRules() {
        return null;
    }

    @Override
    public Integer getGuessedWords() {
        return null;
    }

    @Override
    public void resetScore() {
        score = 0;
    }
}
