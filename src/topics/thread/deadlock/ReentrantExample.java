package topics.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("inner method");

        } finally {
            lock.unlock();
        }
    }

     static void main() {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
/*
* Normal Lock Behavior

If we used a non-reentrant lock, then:
A thread that already holds the lock tries to acquire it again → it would block forever → deadlock with itself.

ReentrantLock Behavior

A ReentrantLock is re-entrant, meaning:
If the same thread tries to acquire the lock multiple times, it’s allowed.
Internally, the lock keeps a hold count (how many times the lock has been acquired by the same thread).
Every lock() increments the hold count.
Every unlock() decrements the hold count.
The lock is considered fully released only when the hold count reaches 0.
* */