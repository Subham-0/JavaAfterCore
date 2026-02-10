package topics.generics.interfaces;

public interface Container<T>{
    void add(T item);
    T get();
    boolean isEmpty();
    void clear();
}
