package first.games.whowantotbeamillionaire;

import first.IState;

public class MillionaireState<TSource, TResult> implements IState<TSource, TResult> {
    @Override
    public TResult execute(TSource source) {
        return null;
    }

    @Override
    public TResult getCorrectAnswer() {
        return null;
    }
}
