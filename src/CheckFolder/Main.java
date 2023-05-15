package CheckFolder;

public class Main {

    public static void main(String[] args) {


        Thread th1 = new Thread(new Checker("C:\\folderFROM"));
        th1.start();

        try {
            th1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("End of Main");

    }


}
