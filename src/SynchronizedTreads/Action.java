package SynchronizedTreads;

public class Action {
    private String text;
    private boolean next = true;
    private boolean doStop = false;

    public Action() {
    }

    public synchronized String getText() {
        for (;next == true;){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        next = true;
        String tmptext = this.text;

        notifyAll();


        return tmptext;



    }

    public synchronized void setText(String text) {
        for (;next == false;){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.next = false;
        this.text = text;
        System.out.println(this.text);

        notifyAll();
    }

    public boolean isDoStop() {
        return doStop;
    }

    public void setDoStop(boolean doStop) {
        this.doStop = doStop;
    }
}
