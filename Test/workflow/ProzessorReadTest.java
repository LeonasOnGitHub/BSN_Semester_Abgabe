package workflow;

import org.junit.Test;

import java.io.IOException;


public class ProzessorReadTest {

    @Test
    public void goodTest1() throws IOException {
        Prozessor p = new Prozessor();
        p.restoreFromFile();
    }
}
