package topics.thread;

public class Thread_Yield extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }

    }

    static void main() {
        Thread_Yield t1 = new Thread_Yield();
        Thread_Yield t2 = new Thread_Yield();
        t1.start();
        t2.start();
    }
}

//yield() : If other ready-to-run threads of the same priority exist → it gives them a chance.
//If no such threads exist → the current thread continues.
