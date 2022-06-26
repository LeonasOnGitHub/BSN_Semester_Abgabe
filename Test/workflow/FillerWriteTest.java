package workflow;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class FillerWriteTest {

    @Test
    public void goodTest1() throws IOException {
        final int PORT = 123;
        int val1 = 10;
        int val2 = 20;


        String currentPath = new java.io.File(".").getCanonicalPath();
        Filler f = new Filler(new File(currentPath + "\\tempAdd.txt"));
        f.save2File();

    }
}
