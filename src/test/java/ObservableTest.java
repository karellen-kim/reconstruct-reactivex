import org.junit.Test;
import reactive.Observable;
import reactive.ObservableOnSubscribe;
import reactive.Observer;

/**
 * Created by karellen.kim on 2018. 9. 20...
 */
public class ObservableTest {

    @Test
    public void test_basic() {
        Observable<String> observable = Observable.create(
                // Data Provider
                new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(Observer<String> subscriber) {
                        subscriber.onNext("Hello");
                        subscriber.onNext("world!");
                        subscriber.onCompleted();
                    }
                }
        );
        // Observer
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        // Start subscribe
        observable.subscribe(observer);
    }

    @Test
    public void test_lambda() {
        Observable<String> observable = Observable.create(subscriber -> {
            subscriber.onNext("Hello");
            subscriber.onNext("world!");
            subscriber.onCompleted();
        });

        observable.subscribe(
                o -> System.out.println(o),
                error-> System.out.println(error),
                complete -> System.out.println(complete));
    }

    @Test
    public void test_just() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6);
        observable.subscribe(item -> System.out.println(item));
    }

    @Test
    public void test_map() {
        Observable<Integer> observable =
                Observable.just(1, 2, 3, 4, 5, 6);
        observable.subscribe(item -> System.out.println(item));
    }
}
