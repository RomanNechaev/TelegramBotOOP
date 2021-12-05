package first.games.interfaces;

public interface IScheme<TSource, TResult> {
    Boolean next();
    void nullify();
    IState<TSource, TResult> getCurrentState();
    void addState(IState<TSource, TResult> state);
}
