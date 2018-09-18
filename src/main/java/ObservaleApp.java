/**
 * Created by karellen.kim on 2018. 9. 18...
 */
public class ObservaleApp {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(
                new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(Observer<String> subscriber) {
                        subscriber.onNext("Hello");
                        subscriber.onNext("world!");
                        subscriber.onCompleted();
                    }
                }
        );
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

        observable.subscribe(observer);
    }
}