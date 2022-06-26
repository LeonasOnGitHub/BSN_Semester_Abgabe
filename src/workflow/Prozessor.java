package workflow;

import java.io.*;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Scanner;


public class Prozessor extends Thread {

    private int value;
    private File file;
    private int value2;
    private int result;

    public  Prozessor(File file){
        this.file=file;
    }

    void restoreFromFile() throws IOException, InterruptedException {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //count lines of the text file
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read out text file
        for (int i = 0; i < lines; i++) {
            InputStream is = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(is);
            this.value = dis.readInt();
            dis.readByte();
            this.value2 = dis.readInt();

            result = value + value2;
            Timestamp time = new Timestamp(System.currentTimeMillis());

            System.out.println(time + ": " + value + " + " + value2 + " = " + result);

            removeFirstLine(String.valueOf(file));
        }
    }

    public void removeFirstLine(String fileName) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        //Initial write position
        long writePosition = raf.getFilePointer();
        raf.readLine();
        // Shift the next lines upwards.
        long readPosition = raf.getFilePointer();

        byte[] buff = new byte[1024];
        int n;
        while (-1 != (n = raf.read(buff))) {
            raf.seek(writePosition);
            raf.write(buff, 0, n);
            readPosition += n;
            writePosition += n;
            raf.seek(readPosition);
        }
        raf.setLength(writePosition);
        raf.close();
    }
}
