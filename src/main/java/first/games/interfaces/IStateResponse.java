package first.games.interfaces;

public interface IStateResponse<TResult> {
    Boolean isSuccessful();
    TResult getResult();
}
