package topics.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WildcardExample {

    // Unbounded wildcard - accepts any type
    public static void printList(List<?> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Upper bounded wildcard - accepts Number and its subclasses
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // Upper bounded wildcard - print numbers
    public static void printNumbers(List<? extends Number> numbers) {
        System.out.println("Numbers in list:");
        for (Number num : numbers) {
            System.out.println("  " + num + " (" + num.getClass().getSimpleName() + ")");
        }
    }

    // Lower bounded wildcard - accepts Integer and its superclasses
    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    // Lower bounded wildcard - add numbers
    public static void addNumbers(List<? super Number> list) {
        list.add(10);
        list.add(20.5);
        list.add(30.7f);
        list.add(40L);
    }

    // Method demonstrating PECS (Producer Extends, Consumer Super)
    public static void copy(List<? extends Number> source, List<? super Number> destination) {
        for (Number num : source) {
            destination.add(num);
        }
    }

    public static void main(String[] args) {
        // Unbounded wildcard example
        System.out.println("=== Unbounded Wildcard ===");
        List<String> stringList = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.print("String List: ");
        printList(stringList);

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.print("Integer List: ");
        printList(intList);

        // Upper bounded wildcard example
        System.out.println("\n=== Upper Bounded Wildcard (? extends Number) ===");
        List<Integer> integers = Arrays.asList(10, 20, 30, 40);
        System.out.println("Integer list sum: " + sumNumbers(integers));
        printNumbers(integers);

        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        System.out.println("\nDouble list sum: " + sumNumbers(doubles));
        printNumbers(doubles);

        List<Float> floats = Arrays.asList(10.5f, 20.5f, 30.5f);
        System.out.println("\nFloat list sum: " + sumNumbers(floats));
        printNumbers(floats);

        // Lower bounded wildcard example
        System.out.println("\n=== Lower Bounded Wildcard (? super Integer) ===");
        List<Integer> integerList = new ArrayList<>();
        System.out.println("Adding integers to Integer list...");
        addIntegers(integerList);
        System.out.println("Result: " + integerList);

        List<Number> numberList = new ArrayList<>();
        System.out.println("\nAdding integers to Number list...");
        addIntegers(numberList);
        System.out.println("Result: " + numberList);

        List<Object> objectList = new ArrayList<>();
        System.out.println("\nAdding integers to Object list...");
        addIntegers(objectList);
        System.out.println("Result: " + objectList);

        // PECS example
        System.out.println("\n=== PECS Example (Producer Extends, Consumer Super) ===");
        List<Integer> source = Arrays.asList(100, 200, 300);
        List<Number> destination = new ArrayList<>();

        System.out.println("Source: " + source);
        System.out.println("Destination before copy: " + destination);

        copy(source, destination);

        System.out.println("Destination after copy: " + destination);

        // Adding more numbers
        System.out.println("\nAdding mixed numbers to Number list...");
        List<Number> mixedNumbers = new ArrayList<>();
        addNumbers(mixedNumbers);
        System.out.println("Result: " + mixedNumbers);
    }
}