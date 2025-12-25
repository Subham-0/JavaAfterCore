package topics.collection.set;

import java.util.*;

public class BasicSet {
    static void main() {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); //Duplicate, won't be added
        hashSet.add(null);
        hashSet.add(null); //allow one null element
        System.out.println(hashSet);
        //No Order guaranteed
        //[null, Apple, Orange, Banana]

        Set<String> linkedHashset = new LinkedHashSet<>();
        linkedHashset.add("Apple");
        linkedHashset.add("Banana");
        linkedHashset.add("Orange");

        linkedHashset.add(null);
        linkedHashset.add(null);
        //one null element allow

        System.out.println(linkedHashset);
        //[Apple, Banana, Orange] (insertion order preserved)

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);

        //treeSet.add(null); // no null element allow
        // throw NullPointerException
        System.out.println(treeSet);
        //[1, 2, 5, 8] (sorted order)

        // TreeSet specific operations
        TreeSet<Integer> tree = new TreeSet<>(treeSet);
        System.out.println("First: " + tree.first()); // 1
        System.out.println("Last: " + tree.last());   // 8
        System.out.println("Higher than 2: " + tree.higher(2)); // 5
        System.out.println("Lower than 5: " + tree.lower(5));   // 2

        enum Day{
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }
        Set<Day> weekend = EnumSet.of(Day.SATURDAY,Day.SUNDAY);
        Set<Day> weekdays = EnumSet.range(Day.MONDAY,Day.FRIDAY);
        Set<Day> allDays = EnumSet.allOf(Day.class);

        System.out.println(weekend);
        //[SATURDAY, SUNDAY]
        System.out.println(weekdays);
        //[MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]
        System.out.println(allDays);
        //[MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
    }
}
