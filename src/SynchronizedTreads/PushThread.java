package SynchronizedTreads;

public class PushThread implements Runnable{

    private Action action;


    public PushThread(Action action) {

        this.action = action;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        for (int i = 0; i < 5; i+=1) {
            action.setText("#"+i +"Push complete");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

        action.setDoStop(true);
        th.interrupt();


    }
}
