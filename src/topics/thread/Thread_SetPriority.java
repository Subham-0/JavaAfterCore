package topics.thread;

public class Thread_SetPriority extends Thread {

    public Thread_SetPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
        String s= "";
        for(int i = 0;i<100000000;i++){
            s+="";
        }
        for (int i = 1; i < 6; ) {
            System.out.println(Thread.currentThread().getName() + " - Priority - " + Thread.currentThread().getPriority() + " count : " + i++);

        }
    }

     static void main() {
        Thread_SetPriority h = new Thread_SetPriority("High");
        Thread_SetPriority m = new Thread_SetPriority("Medium");
        Thread_SetPriority l = new Thread_SetPriority("Low");
        h.setPriority(MAX_PRIORITY);
        m.setPriority(NORM_PRIORITY);
        l.setPriority(MIN_PRIORITY);
        h.start();
        m.start();
        l.start();
    }
}

/*It’s only a hint to the OS scheduler, not a guarantee.

The thread scheduler is OS-dependent:

On Windows, priorities may affect scheduling a little.

On Linux/Mac, JVM often ignores it (all threads treated equally).

So setPriority() may work or not work, depending on your system.*/

