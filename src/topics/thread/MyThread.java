package topics.thread;

public class MyThread extends Thread {
    @Override
    public void run() {

    }

    static void main(String[] args) {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
    }
}
