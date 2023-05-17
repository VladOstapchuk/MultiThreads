package SynchronizedTreads;

public class Main {
    public static void main(String[] args) {

        Action act = new Action();
        PushThread push = new PushThread(act);
        PullThread pull = new PullThread(act);

        Thread th1 = new Thread(push);
        Thread th2 = new Thread(pull);

        if (!th1.isInterrupted()) {

            th1.start();
            th2.start();
        }



    }
}
