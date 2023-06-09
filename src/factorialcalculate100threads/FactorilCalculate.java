package factorialcalculate100threads;

import java.math.BigInteger;

public class FactorilCalculate implements Runnable {
    private int number;

    public FactorilCalculate() {
    }

    public FactorilCalculate(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private BigInteger calculateFactorial(int number) {
        BigInteger factorial = new BigInteger("1");

              for (int i = 2; i <= number; i += 1) {
                factorial = factorial.multiply(new BigInteger("" + i));
            }
        return factorial;
        }



    @Override
    public void run() {
        Thread th = Thread.currentThread();
        long starttime = System.currentTimeMillis();
        System.out.println(th.getName() + " " + calculateFactorial(this.number));
        long endtime = System.currentTimeMillis();
        System.out.println("Time to calculate: " + (endtime - starttime) + " " + th.getName());

    }
}
