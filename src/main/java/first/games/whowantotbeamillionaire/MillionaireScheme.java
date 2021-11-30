package first.games.whowantotbeamillionaire;

import first.games.interfaces.IScheme;
import first.games.interfaces.IState;

import java.util.ArrayList;
import java.util.List;

public class MillionaireScheme implements IScheme<String, String> {
    private final List<IState<String, String>> states;
    private Integer index;

    public MillionaireScheme() {
        states = new ArrayList<>();
        index = 0;
    }

    @Override
    public IState<String, String> getCurrentState() {
        return states.get(index);
    }

    @Override
    public Boolean next() {
        index++;
        return index < states.size();
    }

    @Override
    public void addState(IState<String, String> state) {
        states.add(state);
    }

    @Override
    public void nullify() {
        states.clear();
        index = 0;
    }
}
