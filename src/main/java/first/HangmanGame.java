package first;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;

public class HangmanGame {
    private String word;
    private HashSet<Character> wordHashSet;
    private HashSet<Character> guessedLetters = new HashSet<>();
    private HashSet<Character> usedLetters = new HashSet<>();
    private FileHandler fileHandler = new FileHandler("hangmanWords.txt");
    private String WIN_TEXT = "Ты выиграл!";
    private String LOSE_TEXT = "Ты проиграл((";
    private String ALREADY_USED_LETTER = "Буква была введена ранее, введите другую!";
    private String ONLY_ONE_LETTER = "Ты должен написать только одну букву!";

    private int healthPoints = 6;

    public HangmanGame() throws FileNotFoundException {
        setWord();
    }

    public void setWord(){
        this.word = fileHandler.getNextWord();
        wordHashSet = getHashSetByWordChars(word);
        guessedLetters = new HashSet<>();
        usedLetters = new HashSet<>();
        healthPoints = 6;
    }

    public void setWord(String word){
        this.word = word;
        wordHashSet = getHashSetByWordChars(word);
        guessedLetters = new HashSet<>();
        usedLetters = new HashSet<>();
        healthPoints = 6;
    }

    public String getWord(){
        return word;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String checkAnswer(String answer) {
        if (answer.length() != 1) return ONLY_ONE_LETTER;
        var userChar = answer.toLowerCase().charAt(0);
        if (usedLetters.contains(userChar)) {
            return ALREADY_USED_LETTER;
        }
        usedLetters.add(userChar);
        if (wordHashSet.contains(userChar))
            guessedLetters.add(userChar);
        else healthPoints--;
        if (isWin()) {
            return getWordWithGuessedLetters() + "\n" + WIN_TEXT;
        }
        if (healthPoints == 0) {
            return LOSE_TEXT;
        }
        return getWordWithGuessedLetters() + "\n" + "Осталось жизней: " + healthPoints;
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
            if (guessedLetters.contains(ch.toString().toLowerCase(Locale.ROOT).charAt(0))) {
                resultStr.append(ch).append(" ");
            } else {
                resultStr.append("* ");
            }
        }
        return resultStr.toString();
    }

    private HashSet<Character> getHashSetByWordChars(String word) {
        var characters = new HashSet<Character>();
        for (Character ch : word.toLowerCase().toCharArray()) {
            characters.add(ch);
        }
        return characters;
    }


}

