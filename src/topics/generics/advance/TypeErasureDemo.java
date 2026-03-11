package topics.generics.advance;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureDemo {

    // Generic class - before type erasure
    static class Box<T> {
        private T content;

        public void set(T content) {
            this.content = content;
        }

        public T get() {
            return content;
        }
    }

    // After compilation, becomes (conceptually):
    // class Box {
    //     private Object content;
    //     public void set(Object content) { this.content = content; }
    //     public Object get() { return content; }
    // }

    // Generic method with bounded type
    static class BoundedBox<T extends Number> {
        private T value;

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public double getDoubleValue() {
            return value.doubleValue(); // This works because of the bound
        }
    }

    // After compilation, becomes (conceptually):
    // class BoundedBox {
    //     private Number value;
    //     public void setValue(Number value) { this.value = value; }
    //     public Number getValue() { return value; }
    //     public double getDoubleValue() { return value.doubleValue(); }
    // }

    // Generic method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // After type erasure, this method becomes:
    // public static void printArray(Object[] array) {
    //     for (Object element : array) {
    //         System.out.print(element + " ");
    //     }
    //     System.out.println();
    // }

    // Demonstrating bridge methods
    static class Node<T> {
        public T data;

        public Node(T data) {
            this.data = data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    static class MyNode extends Node<Integer> {
        public MyNode(Integer data) {
            super(data);
        }

        // This method overrides the generic method
        // Compiler creates a bridge method to maintain compatibility
        public void setData(Integer data) {
            super.setData(data);
            System.out.println("MyNode setData called with: " + data);
        }
    }

    static void main() {
        System.out.println("=== Type Erasure Demo ===\n");

        // Example 1: Basic type erasure
        System.out.println("1. Basic Generic Class:");
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        String str = stringBox.get(); // No explicit cast needed in source code
        System.out.println("Retrieved: " + str);
        // At runtime, this is actually: String str = (String) stringBox.get();

        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        Integer num = intBox.get();
        System.out.println("Retrieved: " + num);

        // Example 2: Bounded type erasure
        System.out.println("\n2. Bounded Generic Class:");
        BoundedBox<Integer> intBoundedBox = new BoundedBox<>();
        intBoundedBox.setValue(100);
        System.out.println("Value: " + intBoundedBox.getValue());
        System.out.println("Double value: " + intBoundedBox.getDoubleValue());

        BoundedBox<Double> doubleBoundedBox = new BoundedBox<>();
        doubleBoundedBox.setValue(99.99);
        System.out.println("Value: " + doubleBoundedBox.getValue());
        System.out.println("Double value: " + doubleBoundedBox.getDoubleValue());

        // Example 3: Generic method type erasure
        System.out.println("\n3. Generic Method:");
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C"};

        System.out.print("Integer array: ");
        printArray(intArray);

        System.out.print("String array: ");
        printArray(strArray);

        // Example 4: Bridge methods
        System.out.println("\n4. Bridge Methods Demo:");
        MyNode node = new MyNode(50);
        node.setData(100); // Calls the overridden method

        // Example 5: Type erasure limitations
        System.out.println("\n5. Type Erasure Limitations:");

        // Cannot check instance of parameterized types
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        System.out.println("stringList instanceof List: " + (stringList instanceof List));
        System.out.println("integerList instanceof List: " + (integerList instanceof List));
        // Cannot do: stringList instanceof List<String>
        // Both lists have the same runtime class
        System.out.println("Both have same class: " +
                (stringList.getClass() == integerList.getClass()));

        // Example 6: Type information at runtime
        System.out.println("\n6. Runtime Type Information:");
        Box<String> box1 = new Box<>();
        Box<Integer> box2 = new Box<>();

        System.out.println("box1 class: " + box1.getClass().getName());
        System.out.println("box2 class: " + box2.getClass().getName());
        System.out.println("Same class at runtime: " +
                (box1.getClass() == box2.getClass()));

        System.out.println("\nKey Takeaway: Generic type information exists only at");
        System.out.println("compile-time. At runtime, all generic types are erased!");
    }
}