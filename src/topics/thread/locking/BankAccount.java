package topics.thread.locking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 2000;

    // ReentrantLock is used to control access between multiple threads
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        try {
            // Try to acquire the lock within 1 second
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                // Lock acquired successfully
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdraw " + amount);

                        // Simulate transaction processing (thread holds the lock for 3 seconds)
                        Thread.sleep(3000);

                        // Deduct balance after processing
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + " completed withdrawal. Remaining balance : " + balance);

                    } catch (InterruptedException e) {
                        // Best practice: restore the interrupt status instead of swallowing it
                        Thread.currentThread().interrupt();
                    } finally {
                        // Always release the lock so other threads can continue
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                // If lock not acquired within 1 second → thread gives up
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
        } catch (InterruptedException e) {
            // If tryLock itself was interrupted → restore interrupt flag
            Thread.currentThread().interrupt();
        }

        // (Optional) Check if the thread was interrupted during processing
        if (Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " was interrupted during transaction");
        }
    }
}
