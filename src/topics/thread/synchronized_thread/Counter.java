package topics.thread.synchronized_thread;

public class Counter {
    private int count;

    public  void  increment(){
        // We could mark the whole method as 'synchronized',
        // but here only the critical section (count++) needs synchronization.
        synchronized(this) {
            count++;
            /*synchronized (this) ensures that only one thread at a time can modify count
            for the same object instance.*/
        }
    }

    public int getCount() {
        return count;
    }
}
