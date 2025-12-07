package topics.thread.read_write_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockCounter {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readlock = lock.readLock();
    private final Lock writelock = lock.writeLock();

    public void increment() {
        writelock.lock();
        try {
            count++;
        } finally {
            writelock.unlock();
        }
    }

    public int getCount() {
        readlock.lock();
        try {
            return count;
        } finally {
            readlock.unlock();
        }
    }

     static void main() {
        ReadWriteLockCounter counter = new ReadWriteLockCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            }
        };

        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        try {
            writeThread.join();
            readThread1.join();
            readThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
//A ReadWriteLock gives two locks:
//Read lock → Many threads can hold it at the same time (as long as no one is writing).
//Write lock → Only one thread can hold it, and when it does, no reader can read.