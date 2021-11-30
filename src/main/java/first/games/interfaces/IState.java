package first.games.interfaces;

public interface IState<TSource, TResult> {
    IStateResponse<TResult> execute(TSource source);
}
