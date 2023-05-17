package SynchronizedTreads;

public class PullThread implements Runnable{

    private Action action;


    public PullThread(Action action) {

        this.action = action;
    }

    @Override
    public void run() {
        for (;!action.isDoStop() == true; ) {

            System.out.println("Pull complete! Text is: " + action.getText() );
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}