package topics.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeInterface {
    static void main() {
        Deque<String> deque = new ArrayDeque<>();

        deque.addFirst("A");
        deque.addFirst("C");
        deque.addFirst("Z");
        deque.addFirst("D");
        System.out.println(deque);

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println( deque.peekFirst());
        System.out.println(deque.peekLast());

        deque.push("X");
        System.out.println(deque);
        deque.pop();

        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        deque.pollFirst();
        deque.pollLast();
        System.out.println(deque);
    }

}
