package FileWhatcher;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileWatcher implements Runnable{
    private File mainFolder;

    public FileWatcher(File mainFolder) {
        this.mainFolder = mainFolder;
    }

    public File getMainfolder() {
        return mainFolder;
    }

    private String getFolderInfo(){
        if (mainFolder == null){
            return "None";
        }
        StringBuilder strbl = new StringBuilder();
        File[] files = this.mainFolder.listFiles();
        for (File file: files
             ) {
            strbl.append(file.getName() + "\t" + file.length()).append(System.lineSeparator());

        }
        return  strbl.toString();
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");

            for (;!th.isInterrupted();) {
            System.out.println(sdf.format(System.currentTimeMillis()));
            System.out.println(getFolderInfo());
            System.out.println();
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("File Watcher stopped!");

    }
}
