package first;

public interface IState<TSource, TResult> {
    TResult execute(TSource source);
    TResult getCorrectAnswer();
}
