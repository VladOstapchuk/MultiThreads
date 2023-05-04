package arrayelementcalculate;

import java.math.BigInteger;
import java.util.Arrays;

public class Arrayint implements Runnable {


    private int arraylenght;
    private int[] bigarray;
    private Thread thr;
    private int threadsNumber;

    private int startindex;
    private int endindex;



    public Arrayint(int[] bigarray, int startindex, int endindex) {
        this.bigarray = bigarray;
        this.startindex = startindex;
        this.endindex = endindex;

        thr = new Thread(this);
        thr.start();

    }

    public int getArraylenght() {
        return arraylenght;
    }

    public int[] getBigarray() {
        return bigarray;
    }

    public Thread getThr() {
        return thr;
    }


//    private int[] fillarray(int arraylenght) {
//
//        bigarray = new int[arraylenght];
//
//        for (int i = 0; i < bigarray.length; i++) {
//            bigarray[i] = (int) (Math.random() * 10);
//        }
//
//        return bigarray;
//    }



    public int calculate(int from, int to) {
        int result = -1;
        if (bigarray == null) {
            return -1;
        } else {

            for (int i = from; i < to; i++) {
                result = result + bigarray[i];
            }
        }
        return result;
    }


    @Override
    public void run() {
        Thread th = Thread.currentThread();

        System.out.println(th.getName() +" Summ is: " + calculate(startindex, endindex));

    }


    @Override
    public String toString() {
        return "Arrayint{" +
                "arraylenght=" + arraylenght +
                ", bigarray=" + Arrays.toString(bigarray) +
                '}';
    }
}
