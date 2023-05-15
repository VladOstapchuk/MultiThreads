package CheckFolder;

import java.io.File;
import java.util.Arrays;

public class Checker implements Runnable  {

    private String folderName;
    private File file;
    private String[] tmpArray;


    public Checker(String folderName) {
        this.folderName = folderName;
        this.file = new File(folderName);
        this.tmpArray = file.list();


    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }


    private String checkMethod(){

        String[] filesArray = file.list();

        StringBuilder stb = new StringBuilder();

                if (file == null){
                    return "Folder not found";
                } else if (Arrays.equals(tmpArray, filesArray)) {
                    return "No changes";
                }
                 else{
                    for (String string: tmpArray ) {



                        for (int i = 0; i < filesArray.length; i++){

                        if (filesArray[i].equals(string)){
                            break;
                        } else {
                            stb.append(filesArray[i] + System.lineSeparator());
                            tmpArray = filesArray;
                            break;
                        }

                    }
                        }



                    } return stb.toString();
    }



    @Override
    public void run() {
        Thread th = Thread.currentThread();
        for (; !th.isInterrupted(); ) {
            System.out.println(checkMethod());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
