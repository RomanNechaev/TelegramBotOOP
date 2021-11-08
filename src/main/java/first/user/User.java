package first.user;

import first.IGame;
import first.hangman.HangmanGameState;
import java.util.Comparator;
import java.util.HashMap;

public class User implements Comparable<User>{
    private final long id;
    public int score;
    public UserState state;
    public IGame gameState;
    public Boolean stateIsChanged = true;
    public Integer guessedWords;
    public String userName;
    public Boolean flagName;

    public User(long id) {
        state = UserState.onMenu;
        gameState = new HangmanGameState();
        guessedWords = 0;
        flagName = true;
        this.id = id;
    }
    public User withScore(int score){
        this.score = score;
        return this;
    }
    public User withUserName(String userName){
        this.userName = userName;
        return this;
    }

    public Boolean isPlaying() {
        return state == UserState.Playing;
    }

    public void changeGame(IGame game) {
        gameState = game;
    }

    public String getName() {
        return userName;
    }

    public int getGuessedWord() {
        return guessedWords;
    }

    public void changeState(UserState state) {
        stateIsChanged = true;
        this.state = state;
        switch (state) {
            case Playing:
                gameState.start();
                break;
            case onMenu:
                break;
        }
    }
    public long getId() {
        return id;
    }

    @Override
    public int compareTo(User user) {
        return getName().compareTo(user.getName());
    }

    public static class GuessedWordComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getGuessedWord() - o2.getGuessedWord();
        }
    }
}
