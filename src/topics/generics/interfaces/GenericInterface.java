package topics.generics.interfaces;


public class GenericInterface {
    static void main() {
        // Test Box with String
        System.out.println("=== Box<String> Test ===");
        Container<String> stringBox = new Box<>();
        System.out.println("Is empty: " + stringBox.isEmpty());
        stringBox.add("Hello Generics");
        System.out.println("Is empty: " + stringBox.isEmpty());
        System.out.println("Retrieved: " + stringBox.get());
        stringBox.clear();
        System.out.println("Is empty: " + stringBox.isEmpty());

        // Test Box with Integer
        System.out.println("\n=== Box<Integer> Test ===");
        Container<Integer> intBox = new Box<>();
        intBox.add(42);
        System.out.println("Retrieved: " + intBox.get());

        // Test Stack with String
        System.out.println("\n=== SimpleStack<String> Test ===");
        SimpleStack<String> stringStack = new SimpleStack<>();
        stringStack.add("First");
        stringStack.add("Second");
        stringStack.add("Third");
        System.out.println("Stack size: " + stringStack.size());

        System.out.println("\nPopping elements:");
        while (!stringStack.isEmpty()) {
            System.out.println("Popped: " + stringStack.get());
        }
        System.out.println("Stack size after popping: " + stringStack.size());

        // Test Stack with Integer
        System.out.println("\n=== SimpleStack<Integer> Test ===");
        SimpleStack<Integer> intStack = new SimpleStack<>();
        intStack.add(10);
        intStack.add(20);
        intStack.add(30);
        intStack.add(40);

        System.out.println("\nPopping two elements:");
        System.out.println("Popped: " + intStack.get());
        System.out.println("Popped: " + intStack.get());
        System.out.println("Remaining stack size: " + intStack.size());
    }
}
