package topics.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOperation {
    static void main() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // remove from front
        while(!queue.isEmpty()){
            int value = queue.poll();
            System.out.println(value);
        }

        // Check if empty
        if(queue.isEmpty()){
            System.out.println("Queue is empty");
        }

        // Peek without removing
        queue.offer(100);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Size: " + queue.size());


    }
}
