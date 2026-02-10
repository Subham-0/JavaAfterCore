package topics.generics.interfaces;

public class SimpleStack<T> implements Container<T> {
    private java.util.ArrayList<T> stack;

    public SimpleStack() {
        stack = new java.util.ArrayList<>();
    }

    @Override
    public void add(T item) {
        stack.add(item);
        System.out.println("Pushed: " + item);
    }

    @Override
    public T get() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void clear() {
        stack.clear();
        System.out.println("Stack cleared");
    }
    public int size() {
        return stack.size();
    }
}
