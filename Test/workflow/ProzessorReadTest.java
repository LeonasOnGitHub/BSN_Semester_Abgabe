package workflow;

import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class ProzessorReadTest {

    @Test
    public void goodTest1() throws IOException {
        String currentPath = new java.io.File(".").getCanonicalPath();
        Prozessor p = new Prozessor(new File(currentPath + "\\tempAdd.txt"));
        p.restoreFromFile();
    }
}
