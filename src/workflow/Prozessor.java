package workflow;

import java.io.*;

public class Prozessor {

    private int value;
    private File file;
    private int value2;

    public  Prozessor(File file){
        this.file=file;
    }
    void restoreFromFile() throws IOException {

        InputStream is = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(is);
        this.value = dis.readInt();
        dis.readByte();
        this.value2 = dis.readInt();

        System.out.println(value);
        System.out.println(value2);
    }
}
