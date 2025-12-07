package topics.thread;

public class StartRunJoinSleep extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

     static void main() throws InterruptedException {
        StartRunJoinSleep t1 = new StartRunJoinSleep();
        t1.start();
        t1.join();
        System.out.println("task complete");
    }
}
