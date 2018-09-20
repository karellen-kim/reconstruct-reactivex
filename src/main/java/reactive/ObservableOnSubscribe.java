package reactive;

/**
 * Created by karellen.kim on 2018. 9. 20...
 */
public interface ObservableOnSubscribe<T> {
    void subscribe(Observer<T> subscriber);
}
