package workflow;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Prozessor {

    private int value;
    private final String FILENAME = "tempAdd.txt";
    private int value2;

    void restoreFromFile() throws IOException {

        InputStream is = new FileInputStream(FILENAME);
        DataInputStream dis = new DataInputStream(is);
        this.value = dis.readInt();
        dis.readByte();
        this.value2 = dis.readInt();

    }
}
