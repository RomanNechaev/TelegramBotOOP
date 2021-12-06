package first.games.whowantotbeamillionaire;

import first.games.interfaces.IScheme;
import first.games.interfaces.ISchemeLoader;
import first.games.interfaces.IGame;
import first.games.interfaces.ISerializeAbleById;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "millionaire")
@Getter
@Setter
public class MillionaireGameState implements IGame, ISerializeAbleById {
    private static ISchemeLoader<String, String> schemeLoader;
    private static IScheme<String, String> scheme;
    private static final String RULES = """
            Игра Кто хочет стать миллионером? - это конкурс викторина,
            в котором участник должен правильно ответить на ряд вопросов с несколькими вариантами ответов,
            чтобы перейти на следующий уровень.
                        
            За каждый правильный ответ тебе будет начисляться 1 балл.
                        
            Если отвечаешь неправильно, то кол-во очков аннулируется, и всё начинается сначала
            Твоя цель - набрать максимальное кол-во очков
                        
            Удачи!""";
    private Integer score;
    @Id
    @Setter
    private Long id;

    public MillionaireGameState(Long id) {
        this(new MillionaireScheme(), new MillionaireSchemeLoader());
        this.id = id;
    }

    public MillionaireGameState(IScheme<String, String> scheme, ISchemeLoader<String, String> schemeLoader) {
        MillionaireGameState.schemeLoader = schemeLoader;
        MillionaireGameState.scheme = scheme;
        score = 0;
    }

    public MillionaireGameState() {
    }

    public long getId() {
        return id;
    }

    @Override
    public String checkAnswer(String message) {
        var res = scheme.getCurrentState().execute(message);
        if (res.isSuccessful() && scheme.next()) {
            score += 1;
        }
        return res.getResult() + "\n" + ((MillionaireState) scheme.getCurrentState()).getQuestionForm().getQuestion()
                + "\n" + String.join("\n", ((MillionaireState) scheme.getCurrentState()).getQuestionForm().getSelection())
                ;
    }

    @Override
    @Transient
    public String getStartMessage() {
        return ((MillionaireState) scheme.getCurrentState()).getQuestionForm().getQuestion() +
                "\n" +
                String.join("\n", ((MillionaireState) scheme.getCurrentState()).getQuestionForm().getSelection());
    }

    @Override
    public void start() {
        scheme.nullify();
        schemeLoader.load(scheme);
    }

    @Override
    public String getRules() {
        return RULES;
    }

    @Override
    public Integer getGuessedWords() {
        return score;
    }

    @Override
    public void resetScore() {
        score = 0;
    }
}
