package topics.thread.synchronized_thread;

public class Mythread extends Thread{
    Counter counter;

    public Mythread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
