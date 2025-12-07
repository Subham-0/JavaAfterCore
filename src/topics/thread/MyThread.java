package topics.thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(1000);
        System.out.println(t1.getState());
        t1.join(); //main method wait until t1 complete it task
        System.out.println(t1.getState());
    }
}
