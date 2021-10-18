package first;

import first.hangman.HangmanGameState;

public class User {
    public UserState state;
    public IGame gameState;
    public Boolean stateIsChanged = false;

    public User() {
        state = UserState.onMenu;
        gameState = new HangmanGameState();
    }

    public Boolean isPlaying() {
        return state == UserState.Playing;
    }

    public void changeGame(IGame game) {
        gameState = game;
    }

    private String startGame() {
        gameState.start();
        return gameState.getStartMessage();
    }

    public void changeState(UserState state) {
        stateIsChanged = true;
        this.state = state;
        switch (state) {
            case Playing:
                startGame();
                break;
            case onMenu:
                break;
        }
    }
}
