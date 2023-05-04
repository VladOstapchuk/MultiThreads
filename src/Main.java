public class Main {
    public static void main(String[] args) {


        Thread[] tharray = new Thread[20000];
        for (int i = 0; i < tharray.length; i++) {
            tharray[i] = new Thread(new FactorilCalculate(i));


        }

        for (int i = 0; i < tharray.length; i++) {
            tharray[i].start();

        }

        for (int i = 0; i < tharray.length; i++) {
            try {
                tharray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }







    }
}