package topics.generics.interfaces;

public class Box<T> implements Container<T> {
    private T item;

    @Override
    public void add(T item) {
        this.item=item;
        System.out.println("Added: item");
    }

    @Override
    public T get() {
        return item;
    }

    @Override
    public boolean isEmpty() {
        return item==null;
    }

    @Override
    public void clear() {
    item = null;
        System.out.println("Box cleared");
    }
}
