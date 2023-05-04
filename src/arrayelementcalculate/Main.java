package arrayelementcalculate;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }





        long tstart = System.currentTimeMillis();
        Arrayint arr1 = new Arrayint(arr, 0, arr.length);
        long tend = System.currentTimeMillis();
        System.out.println("Time 1: " + (tend - tstart));



        tstart = System.currentTimeMillis();
        MultiThreadMethod.multistart(arr, 4);
        tend = System.currentTimeMillis();
        System.out.println("Time 2: " + (tend - tstart));





    }










}
