package topics.thread.fair_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock {
    private final Lock lock = new ReentrantLock(true);

    public void accessResources() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(10);
//            if we don't process any operation still it is in FIFO order
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " release the lock");
            lock.unlock();
        }
    }


    static void main() {
        FairLock fairLock = new FairLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                fairLock.accessResources();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");
        Thread t4 = new Thread(task, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

//FairLock:
// A fair lock ensures that threads acquire the lock in the order they requested it (FIFO – First In, First Out).
//This prevents thread starvation, where one thread could keep waiting if others repeatedly acquire the lock before it.