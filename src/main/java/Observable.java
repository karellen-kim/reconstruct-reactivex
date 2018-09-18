/**
 * Created by karellen.kim on 2018. 9. 18...
 */
public class Observable<T> {
    ObservableOnSubscribe<T> subscribe;
    private Observable(ObservableOnSubscribe<T> subscribe) {
        this.subscribe = subscribe;
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> subscribe) {
        return new Observable<T>(subscribe);
    }

    public void subscribe(Observer<String> observer) {
        subscribe.subscribe(observer);
    }
}

interface ObservableOnSubscribe<T> {
    void subscribe(Observer<String> subscriber);
}

interface Observer<T> {
    void onCompleted();
    void onError(Throwable e);
    void onNext(T s);
}