package first.games.whowantotbeamillionaire;

import first.games.interfaces.IScheme;
import first.games.interfaces.ISchemeLoader;
import first.games.interfaces.IGame;

public class MillionaireGameState implements IGame {
    private final IScheme<String, String> scheme;
    private Integer score;

    public MillionaireGameState() {
        this(new MillionaireScheme(), new MillionaireSchemeLoader());
    }

    public MillionaireGameState(IScheme<String, String> scheme, ISchemeLoader<String, String> schemeLoader) {
        schemeLoader.load(scheme);
        this.scheme = scheme;
    }

    @Override
    public String checkAnswer(String message) {
        var res = scheme.getCurrentState().execute(message);
        if (res.isSuccessful())
            score += 1;
        return res.getResult();
    }

    @Override
    public String getStartMessage() {
        return null;
    }

    @Override
    public void start() {
        scheme.nullify();
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
