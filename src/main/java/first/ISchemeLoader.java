package first;

public interface ISchemeLoader<TSource, TResult> {
    void load(IScheme<TSource, TResult> scheme);
}
