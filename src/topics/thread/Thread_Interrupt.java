package topics.thread;

public class Thread_Interrupt extends  Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Hello");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + e);
        }
    }

     static void main() {
        Thread_Interrupt t1 = new Thread_Interrupt();
        t1.start();
        t1.interrupt();//force to terminate the thread
    }
}
