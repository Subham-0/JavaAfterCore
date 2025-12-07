package topics.thread;

public class ThreadByExtends extends Thread{
    @Override
    public void run() {
        System.out.println("hello from extended thread");
    }

    static void main(String[] args) {
        ThreadByExtends threadByExtends = new ThreadByExtends();
        threadByExtends.start();
    }
}
