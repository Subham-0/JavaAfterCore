package topics.thread.fair_lock;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void access() {
        try {
            System.out.println(Thread.currentThread().getName() + " trying to lock...");
            lock.lockInterruptibly(); // waits but can be interrupted
            try {
                System.out.println(Thread.currentThread().getName() + " acquired the lock");
                Thread.sleep(3000); // simulate work
            } finally {
                System.out.println(Thread.currentThread().getName() + " released the lock");
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting!");
        }
    }

     static void main() throws InterruptedException {
        InterruptibleLockExample example = new InterruptibleLockExample();

        Thread t1 = new Thread(example::access, "Thread-1");
        Thread t2 = new Thread(example::access, "Thread-2");

        t1.start();
        Thread.sleep(100); // let t1 get the lock
        t2.start();

        Thread.sleep(1000); // wait a bit then interrupt t2
        t2.interrupt();
    }
}
