import java.util.HashSet;
import java.util.Locale;

public class HangmanGame implements IGame {
    private String word;
    private HashSet<Character> wordHashSet;
    private HashSet<Character> guessedLetters = new HashSet<>();
    private HashSet<Character> usedLetters = new HashSet<>();
    private String WIN_TEXT = "Ты выиграл!";
    private String ALREADY_USED_LETTER = "Буква была введена ранее, введите другую!";
    private int unsuccessfulAttemptsCount = 0;

    public HangmanGame(String word) {
        this.word = word;
        wordHashSet = createHashSetByWordChars(word);
    }

    @Override
    public String checkAnswer(String answer) {
        if (answer.length() != 1) return "Ты должен написать только одну букву!";
        var userChar = answer.toLowerCase(Locale.ROOT).charAt(0);
        if (usedLetters.contains(userChar)) {
            return ALREADY_USED_LETTER;
        }
        usedLetters.add(userChar);
        if (wordHashSet.contains(userChar))
            guessedLetters.add(userChar);
        else unsuccessfulAttemptsCount++;
        if (wordHashSet.size() == guessedLetters.size()) {
            return getWordWithGuessedLetters() + "\n" + WIN_TEXT;
        }
        if (unsuccessfulAttemptsCount > 5) {
            return "Ты проиграл!";
        }
        return getWordWithGuessedLetters() + "\n" + "Отсалось жизней: " + (6 - unsuccessfulAttemptsCount);
    }

    public Boolean isWin() {
        return wordHashSet.size() == guessedLetters.size();
    }

    public String getHiddenWord() {
        return getWordWithGuessedLetters();
    }

    private String getWordWithGuessedLetters() {
        var resultStr = new StringBuilder();
        for (Character ch : word.toCharArray()) {
            if (guessedLetters.contains(ch)) {
                resultStr.append(ch).append(" ");
            } else {
                resultStr.append("* ");
            }
        }
        return resultStr.toString();
    }

    private HashSet<Character> createHashSetByWordChars(String word) {
        var characters = new HashSet<Character>();
        for (Character ch : word.toCharArray()) {
            characters.add(ch);
        }
        return characters;
    }


}

