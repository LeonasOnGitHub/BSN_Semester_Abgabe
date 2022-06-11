package workflow;

import java.io.*;

public class Filler {

    private File file;
    private int value1;
    private int value2;

    public Filler(int value1, int value2, File file) {
        this.value1 = value1;
        this.value2 = value2;
        this.file = file;
    }


    void save2File() throws IOException {

        OutputStream os = new FileOutputStream(file, true);
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(this.value1);
        dos.writeBytes(" ");
        dos.writeInt(this.value2);
        dos.writeBytes("\n");

    }
}
