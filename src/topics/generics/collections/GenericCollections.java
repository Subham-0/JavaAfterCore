package topics.generics.collections;

import java.util.*;

public class GenericCollections {

    // Generic method to demonstrate List operations
    public static <T> void demonstrateList(String typeName) {
        System.out.println("=== List<" + typeName + "> Demo ===");
        List<T> list = new ArrayList<>();
        System.out.println("Created empty list");
        System.out.println("Size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
    }

    // Method to work with Set
    public static <T> Set<T> removeDuplicates(List<T> list) {
        return new HashSet<>(list);
    }

    // Method to demonstrate Map operations
    public static <K, V> void printMap(Map<K, V> map) {
        System.out.println("Map contents:");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Method to find common elements
    public static <T> Set<T> findCommonElements(Set<T> set1, Set<T> set2) {
        Set<T> common = new HashSet<>(set1);
        common.retainAll(set2);
        return common;
    }

    // Method to merge two lists
    public static <T> List<T> mergeLists(List<T> list1, List<T> list2) {
        List<T> merged = new ArrayList<>(list1);
        merged.addAll(list2);
        return merged;
    }

    static void main() {
        // ArrayList Demo
        System.out.println("=== ArrayList<String> Demo ===");
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Cherry");
        stringList.add("Apple"); // Duplicate

        System.out.println("List: " + stringList);
        System.out.println("Size: " + stringList.size());
        System.out.println("Get index 1: " + stringList.get(1));
        System.out.println("Contains 'Banana': " + stringList.contains("Banana"));

        // HashSet Demo
        System.out.println("\n=== HashSet<String> Demo ===");
        Set<String> stringSet = removeDuplicates(stringList);
        System.out.println("Set (duplicates removed): " + stringSet);
        System.out.println("Size: " + stringSet.size());

        // LinkedList Demo
        System.out.println("\n=== LinkedList<Integer> Demo ===");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.addFirst(5);
        linkedList.addLast(40);

        System.out.println("LinkedList: " + linkedList);
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());

        // HashMap Demo
        System.out.println("\n=== HashMap<String, Integer> Demo ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        scores.put("David", 88);

        printMap(scores);
        System.out.println("Alice's score: " + scores.get("Alice"));
        System.out.println("Contains 'Eve': " + scores.containsKey("Eve"));

        // TreeMap Demo (sorted)
        System.out.println("\n=== TreeMap<String, Double> Demo ===");
        Map<String, Double> prices = new TreeMap<>();
        prices.put("Laptop", 999.99);
        prices.put("Mouse", 29.99);
        prices.put("Keyboard", 79.99);
        prices.put("Monitor", 299.99);

        System.out.println("Prices (sorted by key):");
        printMap(prices);

        // TreeSet Demo (sorted set)
        System.out.println("\n=== TreeSet<Integer> Demo ===");
        Set<Integer> sortedNumbers = new TreeSet<>();
        sortedNumbers.add(50);
        sortedNumbers.add(10);
        sortedNumbers.add(30);
        sortedNumbers.add(20);
        sortedNumbers.add(40);

        System.out.println("Sorted numbers: " + sortedNumbers);

        // Queue Demo
        System.out.println("\n=== Queue<String> Demo ===");
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.println("Queue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);

        // Stack Demo
        System.out.println("\n=== Stack<Integer> Demo ===");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);

        // Common operations
        System.out.println("\n=== Common Operations ===");
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("C", "D", "E");

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        List<String> merged = mergeLists(list1, list2);
        System.out.println("Merged: " + merged);

        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        Set<String> common = findCommonElements(set1, set2);
        System.out.println("Common elements: " + common);

        // Priority Queue Demo
        System.out.println("\n=== PriorityQueue<Integer> Demo ===");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(50);
        priorityQueue.offer(20);

        System.out.println("Priority Queue (heap order): " + priorityQueue);
        System.out.println("Polling elements (natural order):");
        while (!priorityQueue.isEmpty()) {
            System.out.println("  " + priorityQueue.poll());
        }
    }
}
