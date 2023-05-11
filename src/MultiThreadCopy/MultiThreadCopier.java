package MultiThreadCopy;

import java.io.File;
import java.io.IOException;

public class MultiThreadCopier implements Runnable{

    private String folderFrom;
    private String folderTo;

    private File[] fileArray;
    private Thread thr;
    private int startindex;
    private int endindex;

    public MultiThreadCopier(String folderFrom, String folderTo, File[] fileArray, int startindex, int endindex) {
        this.folderFrom = folderFrom;
        this.folderTo = folderTo;
        this.fileArray = fileArray;
        this.startindex = startindex;
        this.endindex = endindex;
        thr = new Thread(this);
        thr.start();
    }


// копирует из папки в папку нужный файл или файлы - один объект - один поток
    private String FolderCopy() throws IOException {
        File folderIn = new File(folderFrom);
        File folderOut = new File(folderTo);
        if (folderIn == null || folderOut == null){
            return "None";
        }

        for (int i = startindex; i <= endindex; i+=1) {
            File f = new File(folderOut, fileArray[i].getName());
            f.createNewFile();
            FileOperation.fileCopy(fileArray[i], f);

        }

        return  "Files copied - from MultiThreadCopier";
    }


    @Override
    public void run() {
        Thread th = Thread.currentThread();

        try {
            System.out.println(th.getName() + FolderCopy());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
