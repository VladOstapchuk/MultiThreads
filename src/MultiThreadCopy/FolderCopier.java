package MultiThreadCopy;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FolderCopier implements Runnable {
    private String folderFrom;
    private String folderTo;

 //   private int threadNumber;


    public FolderCopier(String folderFROM, String folderTO ) {
        this.folderFrom = folderFROM;
        this.folderTo = folderTO;
        //this.threadNumber = threadNumber;
    }

    public String getFolderFROM() {
        return folderFrom;
    }

    public String getFolderTO() {
        return folderTo;
    }

////    public int getThreadNumber() {
//        return threadNumber;
//    }


//Распределяем кол-во файлов в массиве на кол-во потоков
    private String FolderCopy() throws IOException {
        File folderIn = new File(folderFrom);
        File folderOut = new File(folderTo);
        if (folderIn == null || folderOut == null){
            return "Folder not found";
        }
        File[] files = folderIn.listFiles();

        //кол-во потоков равно кол-ву файлов в папке
        int threadNumber = files.length;
        if (threadNumber > 4){
            threadNumber = 4;
        }

        int size = (int) Math.ceil((double)files.length / (double)threadNumber);

        MultiThreadCopier[] mThC = new MultiThreadCopier[threadNumber];
        System.out.println(Arrays.toString(files));

        for (int i = 0; i < mThC.length; i+=1) {

            int startindex = size * i;
            int endindex = (((i + 1) * size)-1);
            if ((files.length - endindex) < (size - 1))  {
                endindex = (files.length - 1);


            }

            // не запускаем поток, если для него нет файло (т.е. будет или 3 или 4 потока (для 9 файло - 3 потока
            //))
            if ( startindex <= endindex ) {
                // каждый объект запускает свой поток в конструкторе при создании объекта
                mThC[i] = new MultiThreadCopier(folderFrom, folderTo, files, startindex, endindex);
            }
        }
        return  "Files copied - from FolderCopier";
    }


    @Override
    public void run() {
        try {
            System.out.println(FolderCopy());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
