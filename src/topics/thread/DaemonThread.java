package topics.thread;

class NomalThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class DaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello!");
        }
    }

     static void main() {
        DaemonThread daemonThread = new DaemonThread();
        NomalThread nomalThread = new NomalThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        nomalThread.start();
    }
    /*When all user (non-daemon) threads finish execution,
    the JVM does not wait for daemon threads to complete;
    it terminates them automatically, regardless of the state the daemon threads are in.*/
}
