package topics.collection.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TypeOfQueue {

    public static void queueAsLinkedList(){
        Queue<String> queue = new LinkedList<>();

        //Adding elements
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.println("Queue: "+ queue);
        //Queue: [First, Second, Third]

        // Removing elements (FIFO)
        System.out.println("Removed: " + queue.poll());  // First
        System.out.println("Removed: " + queue.poll());  // Second

        // Peeking at front
        System.out.println("Front: " + queue.peek());    // Third
        System.out.println("Queue size: " + queue.size()); // 1

        /*
        O(1) time for offer and poll operations
        No capacity restrictions
        Allows null elements
        Not thread-safe
        Uses doubly-linked nodes
        */
    }

    public static void queueAsPriorityQueue(){

        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);
        pq.offer(2);
        pq.offer(8);
        pq.offer(1);
        System.out.println(pq); //[1, 2, 8, 5]

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");//1 2 5 8
        }
        System.out.println();
        //Custom comparator (max-heap)
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);

        System.out.println(maxHeap);//[8, 2, 5, 1]

        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll() + " ");//8 5 2 1
        }

        /*
        Elements are ordered by priority, not insertion order
        O(log n) time for offer and poll operations
        O(1) time for peek
        Does not allow null elements
        Not thread-safe
        Uses binary heap internally
        */
    }
    public static void queueAsArrayDeque(){
        Queue<String> deque = new ArrayDeque<>();

        //Queue operations
        deque.offer("A");
        deque.offer("B");
        deque.offer("C");

        System.out.println("Deque: "+deque);
        //Deque: [A, B, C]

        //using as deque (double-ended queue)
        Deque<String> dq = new ArrayDeque<>();
        dq.offerFirst("Front");
        dq.offerLast("Front");
        dq.offerFirst("NewFront");

        System.out.println(dq); // [NewFront, Front, Front]
        System.out.println(dq.pollFirst()); // NewFront
        System.out.println(dq.pollLast()); // Front

        /*
        O(1) amortized time for add and remove at both ends
        More efficient than LinkedList for queue operations
        No capacity restrictions (grows as needed)
        Does not allow null elements
        Not thread-safe
        Faster than Stack for stack operations
         */
    }

    public static void queueAsArrayBlockingQueue(){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        //Producer thread
        Thread producer = new Thread(()->{
            try{
                for(int i =0;i<=10;i++){
                    blockingQueue.put(i);
                    System.out.println("Produced: "+i);
                    Thread.sleep(100);
                }

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        //consumer thread
        Thread consumer = new Thread(()->{
            try {
                for(int i  = 0;i<= 10;i++) {
                    Integer value = blockingQueue.take();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
        /*
        Fixed capacity (must be specified)
        Thread-safe (blocking operations)
        Supports fairness policy for thread ordering
        Blocks when full (on put) or empty (on take)
        Part of java.util.concurrent package
         */
    }
    public static void queueAsLinkedBlockingQueue() throws InterruptedException {
        // Unbounded queue
        BlockingQueue<String> unbounded = new LinkedBlockingQueue<>();

        // Bounded queue
        BlockingQueue<String> bounded = new LinkedBlockingQueue<>(100);

        bounded.put("Message 1");
        bounded.put("Message 2");

        String msg = bounded.take(); // Blocks if empty
        System.out.println("Received: " + msg);

        /*
        Can be bounded or unbounded
        Higher throughput than ArrayBlockingQueue
        Thread-safe with separate locks for head and tail
        Better for high concurrency scenarios
         */
    }

    public static void queueAsPriorityBlockingQueue() throws InterruptedException {
        BlockingQueue<Task> takeQueue = new PriorityBlockingQueue<>();

        takeQueue.put(new Task("Low Priority",3));
        takeQueue.put(new Task("High Priority",1));
        takeQueue.put(new Task("Medium Priority",2));

        while(!takeQueue.isEmpty()){
            System.out.println(takeQueue.take());
        }
        //  High Priority(priority: 1)
        //  Medium Priority(priority: 2)
        //  Low Priority(priority: 3)
    }

    static void main() {
        queueAsLinkedList();
        queueAsPriorityQueue();
        queueAsArrayDeque();
        queueAsArrayBlockingQueue();
        try {
            queueAsLinkedBlockingQueue();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            queueAsPriorityBlockingQueue();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Task implements Comparable<Task>{
    String name;
    int priority;

    public Task(String name,int priority){
        this.name = name;
        this.priority = priority;
    }
    @Override
    public int compareTo(Task other){
        return Integer.compare(this.priority , other.priority);
    }

    @Override
    public String toString(){
        return name+"(priority: "+priority+")";
    }
}
