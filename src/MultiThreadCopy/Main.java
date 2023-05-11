package MultiThreadCopy;

public class Main {
    public static void main(String[] args) {

// Запуск потока, в которые передается адрес папок для копирования и кол-во потоков
        Thread th = new Thread(new FolderCopier("C:\\folderFROM", "C:\\folderTO", 3));
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End of Main");


    }
}
