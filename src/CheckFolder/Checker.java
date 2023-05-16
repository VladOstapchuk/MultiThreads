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

        boolean flag = true;
        int elementposition;

                if (file == null){
                    return "Folder not found";
                } else if (Arrays.equals(tmpArray, filesArray)) {
                    return "No changes";
                }
                 else {

                     // проверка, если файл удалится
                    for (String stringdeleted: tmpArray ) {

                        for (int i = 0; i < filesArray.length; i++){

                        if (stringdeleted.equals(filesArray[i])){
                            flag = true;
                            break;
                        }
                        else {
                            flag = false;
                        }

                        }
                        if (flag == false && stringdeleted != null){
                            stb.append(stringdeleted + " was deleted");
                            tmpArray = filesArray;
                        }
                    }


                        // проверка, если файл добавлен

                        for (String stringadded: filesArray ) {

                            for (int i = 0; i < tmpArray.length; i++){

                                if (filesArray[i].equals(stringadded)){
                                    flag = true;
                                    break;
                                }
                                else {
                                    flag = false;
                                }

                            }
                            if (flag == false && stringadded != null){
                                stb.append(stringadded + " was added");
                                tmpArray = filesArray;
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
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
