package workflow;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Filler {

    private final String FILENAME = "tempAdd.txt";
    private int value1;
    private int value2;

    public Filler(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }


    void save2File() throws IOException {

        OutputStream os = new FileOutputStream(FILENAME, true);
        DataOutputStream dos = new DataOutputStream(os);
       // dos.writeInt(this.value1);
        // dos.writeInt(this.value2);
        dos.writeBytes("4");
        dos.writeBytes("99");
    }
}
