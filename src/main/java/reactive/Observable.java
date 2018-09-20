package reactive;

import java.util.function.Function;

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

    public static <T> Observable<T> just(T ... items) {
        return new Observable<T>(subscriber -> {
            for (T item : items) {
                subscriber.onNext(item);
            }
            subscriber.onCompleted();
        });
    }

    public <R> Observable<R> map(Function<T, R> func) {
        return new Observable<R>();
    }

    public void subscribe(Observer<T> observer) {
        subscribe.subscribe(observer);
    }

    public void subscribe(Action<T> next) {
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(T s) {
                next.apply(s);
            }
        };
        subscribe.subscribe(observer);
    }

    public void subscribe(Action<T> next,
                          Action<Void> completed, Action<Throwable> error) {
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onCompleted() {
                completed.apply(null);
            }

            @Override
            public void onError(Throwable e) {
                error.apply(e);
            }

            @Override
            public void onNext(T s) {
                next.apply(s);
            }
        };
        subscribe.subscribe(observer);
    }
}
