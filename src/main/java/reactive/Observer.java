package reactive;

/**
 * Created by karellen.kim on 2018. 9. 20...
 */
public interface Observer<T> {
    void onCompleted();
    void onError(Throwable e);
    void onNext(T s);
}