package first;

public interface IScheme<TSource, TResult> {
    void changeState();
    void clear();
    IState<TSource, TResult> getCurrentState();
    IScheme<TSource, TResult> addState(IState<TSource, TResult> state);
}
