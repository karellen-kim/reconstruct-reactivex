package reactive;

/**
 * Created by karellen.kim on 2018. 9. 20...
 */
@FunctionalInterface
public interface Action<T> {
    void apply(T t);
}
