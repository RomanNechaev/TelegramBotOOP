package first.games.interfaces;

public interface ISchemeLoader<TSource, TResult> {
    void load(IScheme<TSource, TResult> scheme);
}
