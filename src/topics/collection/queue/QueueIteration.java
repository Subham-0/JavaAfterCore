package topics.collection.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueIteration {
    static void main() {
        Queue<String> queue = new LinkedList<>(
                Arrays.asList("A", "B", "C", "D")
        );

        // Method 1: Using enhanced for loop (doesn't remove elements)
        for (String item : queue) {
            System.out.println(item);
        }

        // Method 2: Using iterator
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Method 3: Using streams (Java 8+)
        queue.stream().forEach(System.out::println);

        // Method 4: Process and remove all elements
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
