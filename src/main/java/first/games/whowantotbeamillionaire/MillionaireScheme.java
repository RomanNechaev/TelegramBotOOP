package first.games.whowantotbeamillionaire;

import first.IScheme;
import first.IState;

import java.util.ArrayList;
import java.util.List;

public class MillionaireScheme<TSource, TResult> implements IScheme<TSource, TResult> {
    private final List<IState<TSource, TResult>> states;
    private Integer index;

    public MillionaireScheme() {
        states = new ArrayList<>();
        index = 0;
    }

    @Override
    public IState<TSource, TResult> getCurrentState() {
        return states.get(index);
    }

    @Override
    public void changeState() {
        index++;
    }

    @Override
    public MillionaireScheme<TSource, TResult> addState(IState<TSource, TResult> state) {
        states.add(state);
        return this;
    }

    @Override
    public void clear() {
        states.clear();
        index = 0;
    }
}
