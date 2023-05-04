package arrayelementcalculate;

public class MultiThreadMethod{

    static void multistart(int[] array, int threadNumber){

        Arrayint[] arrarr = new Arrayint[threadNumber];

        for (int i = 0; i < arrarr.length; i++) {
            int size = array.length / threadNumber;
            int startindex = size * i;
            int endindex = ((i + 1) * size);
            if ((array.length - endindex) < size) {
                endindex = array.length;
            }
            arrarr[i] = new Arrayint(array, startindex, endindex);
        }




    }











}
