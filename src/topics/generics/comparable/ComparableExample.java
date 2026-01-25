package topics.generics.comparable;

import java.util.ArrayList;
import java.util.List;

//Main class demonstrating Comparable with generics
public class ComparableExample {

    static void main() {
        // Test with Integers
        System.out.println("=== Integer List Tests ===");
        List<Integer> intList = new ArrayList<>();
        intList.add(45);
        intList.add(12);
        intList.add(78);
        intList.add(23);
        intList.add(67);

        System.out.println("Original list: " + intList);
        System.out.println("Max: " + SortingUtil.findMax(intList));
        System.out.println("Min: " + SortingUtil.findMin(intList));
        System.out.println("Is sorted: " + SortingUtil.isSorted(intList));

        SortingUtil.bubbleSort(intList);
        System.out.println("After sorting: " + intList);
        System.out.println("Is sorted: " + SortingUtil.isSorted(intList));

        // Test with Strings
        System.out.println("\n=== String List Tests ===");
        List<String> stringList = new ArrayList<>();
        stringList.add("Zebra");
        stringList.add("Apple");
        stringList.add("Mango");
        stringList.add("Banana");
        stringList.add("Cherry");

        System.out.println("Original list: " + stringList);
        System.out.println("Max: " + SortingUtil.findMax(stringList));
        System.out.println("Min: " + SortingUtil.findMin(stringList));
        System.out.println("Is sorted: " + SortingUtil.isSorted(stringList));

        SortingUtil.bubbleSort(stringList);
        System.out.println("After sorting: " + stringList);
        System.out.println("Is sorted: " + SortingUtil.isSorted(stringList));

        // Test with Person objects
        System.out.println("\n=== Person List Tests ===");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 30));
        personList.add(new Person("Bob", 25));
        personList.add(new Person("Charlie", 35));
        personList.add(new Person("David", 28));
        personList.add(new Person("Eve", 32));

        System.out.println("Original list: " + personList);
        System.out.println("Oldest: " + SortingUtil.findMax(personList));
        System.out.println("Youngest: " + SortingUtil.findMin(personList));
        System.out.println("Is sorted by age: " + SortingUtil.isSorted(personList));

        SortingUtil.bubbleSort(personList);
        System.out.println("After sorting by age: " + personList);
        System.out.println("Is sorted by age: " + SortingUtil.isSorted(personList));

    }
}
