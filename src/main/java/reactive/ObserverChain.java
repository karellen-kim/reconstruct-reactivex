package reactive;

/**
 * Created by karellen.kim on 2018. 9. 20...
 */
public abstract class ObserverChain<T> {
    void onCompleted();
    void onError(Throwable e);
    T onNext(T s);
}
