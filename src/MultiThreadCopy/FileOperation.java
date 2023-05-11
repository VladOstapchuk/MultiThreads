package MultiThreadCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


// операционный класс - побайтово копирует файл
public class FileOperation {

    public static void fileCopy (File in, File out) throws IOException {
        byte[] buff = new byte[1024*1024];
        int readByte =0;

        try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
            for (;(readByte = fis.read(buff)) > 0;){
                fos.write(buff, 0, readByte );
            }

        } catch (IOException e){
            throw e;
        }


    }

    public static long folderSize (File folder){
        long result = 0;
        if (folder.isFile()){
            return folder.length();
        } else {
            File[] files = folder.listFiles();
            for (File file: files
                 ) { result += FileOperation.folderSize(file);
            }

        }

        return result;
    }


}
