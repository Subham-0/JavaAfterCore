package topics.thread;
class Task1 {
    public void task() {
        System.out.println("perform task1");
    }
}

// if a class already extends a class in that case we cant again extends Thread class because of multiple inheritance
// only by implements Runnable thread we can make that class also thread
class Thread1 extends Task1 implements Runnable {
    @Override
    public void run() {
        task();
        System.out.println("run method from Thread1 class");
    }
}
public class ThreadByImplements {
    static void main() {
        //Thread1 is not a thread till now we have convert to thread and then we can run the run() by start()
        Thread t1 = new Thread(new Thread1());
        t1.start();
    }
}
