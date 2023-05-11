package FileWhatcher;

import java.io.File;

public class Main {

        public static void main(String[] args) {
            File folder = new File(".");
            Thread th = new Thread(new FileWatcher(folder));
            th.start();

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            th.interrupt();



        }

}
